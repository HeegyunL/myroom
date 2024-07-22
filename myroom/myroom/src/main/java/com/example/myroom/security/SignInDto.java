package com.example.myroom.security;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SignInDto {
    private String userName;
    private String password;

}
