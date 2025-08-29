package com.example.authdemo.dto;

import lombok.Data;

@Data
public class SigninRequest {
    private String username;
    private String password;
}