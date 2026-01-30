package com.example.expense_tracker.controller;

import com.example.expense_tracker.service.AuthService;
import com.example.expense_tracker.service.dto.LoginDTO;
import com.example.expense_tracker.service.dto.RegisterDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class UserController {
    private final AuthService authService;

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegisterDTO registerDTO) {
        authService.register(registerDTO);
    }

    @PostMapping("/login")
    public void login(@Valid @RequestBody LoginDTO loginDTO) {
        authService.Login(loginDTO);
    }
}


