package com.example.expense_tracker.service;

import com.example.expense_tracker.model.User;
import com.example.expense_tracker.model.enumeration.Role;
import com.example.expense_tracker.repository.UserRepository;
import com.example.expense_tracker.service.dto.LoginDTO;
import com.example.expense_tracker.service.dto.RegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {
    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;

    public void register (RegisterDTO registerDTO) {
        if(userRepository.existsByUsername(registerDTO.getUsername())) {
            throw new RuntimeException("Username is already in use");
        }

        if(userRepository.existsByEmail(registerDTO.getEmail())) {
            throw new RuntimeException("Email is already in use");
        }

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setEmail(registerDTO.getEmail());
        user.setRole(Role.USER);
        user.setCreatedDate(LocalDateTime.now());

        userRepository.save(user);
    }

    public String Login(LoginDTO loginDTO) {
        return "Login Success";
    }
}
