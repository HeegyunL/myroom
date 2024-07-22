package com.example.demo.contorller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Iterator;

@Controller
@ResponseBody
public class AdminController {

    @GetMapping("/admin")
    public String adminP() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //현재 사용자
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        //role값
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        GrantedAuthority auth = iterator.next();



        String roles = auth.getAuthority();
        return roles;
    }
}
