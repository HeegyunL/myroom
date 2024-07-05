package com.example.myroom.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/sign-in")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("services/signIn");
        return mav;
    }


    @PostMapping("/sign-in")
    public JwtToken signIn(@RequestBody SignInDto signInDto){
        String username = signInDto.getUsername();
        String password = signInDto.getPassword();

        JwtToken jwtToken = memberService.signIn(username, password);

        log.info("request username = {}, password = {}", username, password);
        log.info("jwtToken accessToken = {}, refreshToken = {}",jwtToken.getAccessToken(),
        jwtToken.getRefreshToken());
        return jwtToken;


    }

    @PostMapping("/test")
    public String test(){
        return SecurityUtil.getCurrentUsername();
    }


}
