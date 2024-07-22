package com.example.demo.service;

import com.example.demo.dto.JoinDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void joinProcess(JoinDto joinDto) {
        String username = joinDto.getUsername();
        String password = joinDto.getPassword();

        Boolean isUser = userRepository.existsByUsername(username);

        if (isUser) {
            return ;
        }

        User data = new User();

        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));  //hash 암호화
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);
    }
}
