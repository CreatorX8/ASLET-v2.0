package com.creatorx.aslet.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class TeacherCreateDto {
    @NotEmpty
    @Size(min = 6, max = 30, message = "name must be between 6 and 30 characters long")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
