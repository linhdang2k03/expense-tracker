package com.example.expense_tracker.controller;

import com.example.expense_tracker.service.AuthService;
import com.example.expense_tracker.service.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO request) {
        return authService.login(
                request.getUsername(),
                request.getPassword()
        );
    }

    @GetMapping("/me")
    public String me(@AuthenticationPrincipal Jwt jwt) {
        return jwt.getSubject();
    }

}


