package com.example.authdemo.controller;

import com.example.authdemo.dto.AuthResponse;
import com.example.authdemo.dto.SigninRequest;
import com.example.authdemo.dto.SignupRequest;
import com.example.authdemo.dto.UserResponse;
import com.example.authdemo.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signup(@RequestBody SignupRequest request) {
        UserResponse userResponse = authService.signup(request);
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody SigninRequest request, HttpServletResponse response) {
        AuthResponse authResponse = authService.signin(request);
        addTokenToCookie(response, authResponse.getToken());
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("jwtToken", null);
        cookie.setHttpOnly(true);
        cookie.setSecure(false); // Mettez à true en production (HTTPS)
        cookie.setPath("/");
        cookie.setMaxAge(0); // Expire immédiatement
        response.addCookie(cookie);
        return ResponseEntity.ok("Déconnexion réussie");
    }

    @GetMapping("/getCurrentUser")
    public ResponseEntity<UserResponse> getCurrentUser(HttpServletRequest request) {
        UserResponse userResponse = authService.getCurrentUser(request);
        return ResponseEntity.ok(userResponse);
    }

    private void addTokenToCookie(HttpServletResponse response, String token) {
        Cookie cookie = new Cookie("jwtToken", token);
        cookie.setHttpOnly(true);  // Protège contre XSS
        cookie.setSecure(false);   // Mettez à true en production (HTTPS)
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60);  // 24 heures
        response.addCookie(cookie);
    }
}