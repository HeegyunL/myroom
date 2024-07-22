package com.example.myroom.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
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
    public JwtToken signIn(@RequestBody SignInDto signInDto){
        String username = signInDto.getUserName();
        String password = signInDto.getPassword();
        JwtToken jwtToken = memberService.signIn(username, password);

        log.info("request username = {}, password = {}", username, password);
        log.info("jwtToken accessToken = {}, refreshToken = {}",jwtToken.getAccessToken(),
                jwtToken.getRefreshToken());

        return jwtToken;


    }
    @PostMapping("/test")
    public String test() {
        return "success";
    }



}
