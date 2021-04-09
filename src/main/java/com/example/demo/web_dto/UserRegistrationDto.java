package com.example.demo.web_dto;

import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRegistrationDto {
    String fullName;
    String username;
    String password;
    String role;


    public UserRegistrationDto(String fullName, String username, String password, String role) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role=role;
    }

    public UserRegistrationDto() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
