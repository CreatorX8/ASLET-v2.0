package com.creatorx.aslet.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private Boolean approved;
    @NotEmpty
    @Size(min = 3, max = 60, message = "province must be between 3 and 60 characters long")
    private String province;
    @NotEmpty
    @Size(min = 3, max = 60, message = "city or village must be between 3 and 60 characters long")
    private String cityVillage;
    @NotEmpty
    @Size(min = 3, max = 60, message = "school name must be between 3 and 60 characters long")
    private String schoolName;

    public UserDto(Long id, String name, String email, String username, String role, Boolean approved, String province, String cityVillage, String schoolName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.role = role;
        this.approved = approved;
        this.province = province;
        this.cityVillage = cityVillage;
        this.schoolName = schoolName;
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

    public Boolean getApproved() {
        return approved;
    }

    public String getProvince() {
        return province;
    }

    public String getCityVillage() {
        return cityVillage;
    }

    public String getSchoolName() {
        return schoolName;
    }
}
