package com.creatorx.aslet.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserDto {
    private Long id;
    @NotEmpty
    @Size(min = 6, message = "name should be at least 6 characters long")
    private String name;
    @NotEmpty
    @Email(message = "invalid email - example: email@example.com")
    private String email;
    @NotEmpty
    @Size(min = 3, message = "username should be at least 3 characters long")
    private String username;
    @NotEmpty
    @Size(min = 4, max = 8, message = "role should be between 4 and 8 characters long")
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
