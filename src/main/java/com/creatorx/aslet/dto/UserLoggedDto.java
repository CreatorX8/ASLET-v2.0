package com.creatorx.aslet.dto;

public class UserLoggedDto {
    private Long id;
    private String name;
    private String email;
    private String username;
    private String role;
    private String province;
    private String cityVillage;
    private String schoolName;
    private String token;

    public UserLoggedDto(Long id, String name, String email, String username, String role, String province, String cityVillage, String schoolName, String token) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.role = role;
        this.province = province;
        this.cityVillage = cityVillage;
        this.schoolName = schoolName;
        this.token = token;
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

    public String getProvince() {
        return province;
    }

    public String getCityVillage() {
        return cityVillage;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getToken() {
        return token;
    }
}
