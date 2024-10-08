package com.example.demo.contorller;

import com.example.demo.entity.RefreshEntity;
import com.example.demo.jwt.JwtUtil;
import com.example.demo.repository.RefreshRepository;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@ResponseBody
public class ReissueController {
    private final JwtUtil jwtUtil;
    private final RefreshRepository refreshRepository;

    public ReissueController(JwtUtil jwtUtil, RefreshRepository refreshRepository) {
        this.jwtUtil = jwtUtil;
        this.refreshRepository = refreshRepository;
    }



    @PostMapping("/reissue")
    public ResponseEntity<?> reissue(HttpServletRequest request, HttpServletResponse response) {

        //get refresh token
        String refresh = null;
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("refresh")) {

                //쿠키를 꺼내서 refresh 변수에 담기
                refresh = cookie.getValue();
            }
        }

        //refresh 토큰이 없다면 에러코드
        if (refresh == null) {
            //response status code
            return new ResponseEntity<>("refresh token is null" , HttpStatus.BAD_REQUEST);

        }

        //expired check
        try {
            jwtUtil.isExpired(refresh);
        } catch (ExpiredJwtException e) {
            return new ResponseEntity<>("access token expired" , HttpStatus.BAD_REQUEST);
        }

        //토큰이 refresh인지 확인 (발급시 페이로드에 명시
        String category = jwtUtil.getCategory(refresh);
        if (!category.equals("refresh")) {

            //response status code
            return new ResponseEntity<>("invalid refresh token", HttpStatus.BAD_REQUEST);
        }

        //DB에 저장되어 있는지 확인
        Boolean isExist = refreshRepository.existsByRefresh(refresh);
        if (!isExist) {
            return new ResponseEntity<>("invalid refresh token", HttpStatus.BAD_REQUEST);
        }

        String username = jwtUtil.getUsername(refresh);
        String role = jwtUtil.getRole(refresh);

        //create new JWT
        String newAccess = jwtUtil.createJwt("access",username, role, 60000L);
        String newRefresh = jwtUtil.createJwt("refresh",username,role,8640000L);

        //Refresh토큰 저장 DB에 기존의 refresh 토큰을 삭제 후 새 Refresh토큰 저장
        refreshRepository.deleteByRefresh(refresh);
        addRefreshEntity(username, newRefresh, 8640000L);

        //response
        response.setHeader("access", newAccess);
        response.addCookie(createCookie("refresh",newRefresh));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Cookie createCookie(String key, String value) {
        Cookie cookie = new Cookie(key,value);
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setHttpOnly(true);
        return cookie;
    }

    private void addRefreshEntity(String username, String refresh, Long expiredMs) {
        Date date = new Date(System.currentTimeMillis() + expiredMs);

        RefreshEntity refreshEntity = new RefreshEntity();
        refreshEntity.setUsername(username);
        refreshEntity.setRefresh(refresh);
        refreshEntity.setExpiration(date.toString());

        refreshRepository.save(refreshEntity);

    }
}
