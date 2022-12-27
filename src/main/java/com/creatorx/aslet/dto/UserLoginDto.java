package com.creatorx.aslet.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserLoginDto {
    @NotEmpty
    @Email(message = "invalid email - example: email@example.com")
    private String email;
    @NotEmpty
    @Size(min = 8, max = 60, message = "password must be between 8 and 60 characters long")
    private String password;

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
}
