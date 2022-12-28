package com.creatorx.aslet.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SubjectDto {
    private Long id;
    @NotEmpty
    @Size(min = 6, max = 30, message = "name must be between 6 and 30 characters long")
    private String name;

    public SubjectDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
