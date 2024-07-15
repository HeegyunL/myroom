package com.example.myroom.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signIn")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("services/login/signIn");
        return mav;
    }


    @PostMapping("/login")
    public ModelAndView signIn(@RequestBody SignInDto signInDto){
        String username = signInDto.getMemberId();
        String password = signInDto.getPassword();
        JwtToken jwtToken = memberService.signIn(username, password);

        log.info("request username = {}, password = {}", username, password);
        log.info("jwtToken accessToken = {}, refreshToken = {}",jwtToken.getAccessToken(),
        jwtToken.getRefreshToken());

        ModelAndView mav = new ModelAndView();

        mav.setViewName("services/test");
        return mav;


    }

    @PostMapping("/test")
    public String test(){
        return SecurityUtil.getCurrentUsername();
    }

    @PostMapping("/signUp")
    public ResponseEntity<MemberDto> signUp(@RequestBody SignUpDto signUpDto) {
        MemberDto savedMemberDto = memberService.signUp(signUpDto);
        return ResponseEntity.ok(savedMemberDto);
    }

}
