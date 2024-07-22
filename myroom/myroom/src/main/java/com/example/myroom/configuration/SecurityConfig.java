package com.example.myroom.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {

        return security

                // JWT를 사용하기 때문에 세션을 사용하지 않음
                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                                // 해당 API에 대해서는 모든 요청을 허가
                                .requestMatchers("/members/**").authenticated()
                                .requestMatchers("/members/login").permitAll()
//                                // USER 권한이 있어야 요청할 수 있음
//                                .requestMatchers("/members/test").hasRole("USER")
                                // 이 밖에 모든 요청에 대해서 인증을 필요로 한다는 설정
                                .anyRequest().permitAll()

                )



                .formLogin(login -> login	// form 방식 로그인 사용
                        .loginPage("/members/signIn")
                        .loginProcessingUrl("/members/login")
                        .usernameParameter("memberId")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/work", true)	// 성공 시 dashboard로
                        .permitAll()
                )

                .logout(Customizer.withDefaults())
                .rememberMe(Customizer.withDefaults())
                .build();
    }




}