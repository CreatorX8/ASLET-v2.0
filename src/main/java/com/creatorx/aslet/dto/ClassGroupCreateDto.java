package com.creatorx.aslet.dto;

import jakarta.validation.constraints.*;

public class ClassGroupCreateDto {
    @NotEmpty
    @Size(min = 6, max = 30, message = "name must be between 6 and 30 characters long")
    private String name;
    @NotNull
    private Long studentsClass;
    @NotNull
    @Min(value = 1, message = "min people count is 1")
    @Max(value = 1000, message = "max people count is 1000")
    private int peopleCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStudentsClass() {
        return studentsClass;
    }

    public void setStudentsClass(Long studentsClass) {
        this.studentsClass = studentsClass;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }
}
