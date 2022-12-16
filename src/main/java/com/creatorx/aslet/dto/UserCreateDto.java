package com.creatorx.aslet.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserCreateDto {
    @NotEmpty
    @Size(min = 6, max = 60, message = "name must be between 6 and 60 characters long")
    private String name;
    @NotEmpty
    @Email(message = "invalid email - example: email@example.com")
    private String email;
    @NotEmpty
    @Size(min = 8, max = 60, message = "password must be between 8 and 60 characters long")
    private String password;
    @NotEmpty
    @Size(min = 3, max = 60, message = "username must be between 3 and 60 characters long")
    private String username;
    @NotEmpty
    @Size(min = 4, max = 8, message = "role must be between 4 and 8 characters long")
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
