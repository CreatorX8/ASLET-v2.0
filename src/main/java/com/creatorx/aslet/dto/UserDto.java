package com.creatorx.aslet.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserDto {
    private Long id;
    @NotEmpty
    @Size(min = 6, max = 60, message = "name must be between 6 and 60 characters long")
    private String name;
    @NotEmpty
    @Email(message = "invalid email - example: email@example.com")
    private String email;
    @NotEmpty
    @Size(min = 3, max = 60, message = "username must be between 3 and 60 characters long")
    private String username;
    @NotEmpty
    @Size(min = 4, max = 8, message = "role must be between 4 and 8 characters long")
    private String role;

    public UserDto(Long id, String name, String email, String username, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}
