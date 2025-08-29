package com.example.authdemo.dto;

import com.example.authdemo.entity.Role;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private Role role;
}