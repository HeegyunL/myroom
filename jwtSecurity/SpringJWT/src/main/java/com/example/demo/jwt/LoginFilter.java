package com.example.demo.jwt;


import com.example.demo.dto.CustomUserDetails;
import com.example.demo.entity.RefreshEntity;
import com.example.demo.repository.RefreshRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private RefreshRepository refreshRepository;

    public LoginFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil,RefreshRepository refreshRepository) {
     this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.refreshRepository = refreshRepository;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request , HttpServletResponse response) throws AuthenticationException {

        //클라이언트 요청에서 로그인 정보 추출
        String username = obtainUsername(request);
        String password = obtainPassword(request);


        //스프링 시큐리티에서 로그인정보를 검증하기 위해서는 토큰에 담아야 함
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password, null);

        //토큰에 담은 정보를 검증하기 위해 authenticationManager로 보냄
        return authenticationManager.authenticate(authToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) {

        //유저 정보
        String username=  authentication.getName();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        GrantedAuthority auth = iterator.next();
        String role = auth.getAuthority();

        //토큰 생성
        String access = jwtUtil.createJwt("access", username, role , 60000L);
        String refresh = jwtUtil.createJwt("refresh", username, role , 8640000L);


        //refresh 토큰 저장
        addRefreshEntity(username , refresh,8640000L);

        response.setHeader("access", access);
        response.addCookie(createCookie("refresh", refresh));
        response.setStatus(HttpStatus.OK.value());


    }

    private void addRefreshEntity(String username, String refresh, Long expiredMs) {
        Date date = new Date(System.currentTimeMillis() + expiredMs);

        RefreshEntity refreshEntity = new RefreshEntity();
        refreshEntity.setUsername(username);
        refreshEntity.setRefresh(refresh);
        refreshEntity.setExpiration(date.toString());

        refreshRepository.save(refreshEntity);

    }

    private Cookie createCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);

        cookie.setMaxAge(24 * 60 * 60);
        cookie.setHttpOnly(true);

        return cookie;
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {
        response.setStatus(401);
    }
}
