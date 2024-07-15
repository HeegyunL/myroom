package com.example.myroom.security;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDto {
    private String memberId;
    private String password;
    private List<String> roles = new ArrayList<>();

    public Member toEntity(String encodedPassword, List<String> roles){
        return Member.builder()
                .memberId(memberId)
                .password(encodedPassword)
                .roles(roles)
                .build();
    }


}
