package com.creatorx.aslet.dto;

import com.creatorx.aslet.model.Class;
import jakarta.validation.constraints.*;

public class ClassGroupDto {
    private Long id;
    @NotEmpty
    @Size(min = 6, max = 30, message = "name must be between 6 and 30 characters long")
    private String name;
    @NotNull
    private Long studentsClass;
    @NotNull
    @Min(value = 1, message = "min people count is 1")
    @Max(value = 1000, message = "max people count is 1000")
    private int peopleCount;

    public ClassGroupDto(Long id, String name, Long studentsClass, int peopleCount) {
        this.id = id;
        this.name = name;
        this.studentsClass = studentsClass;
        this.peopleCount = peopleCount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getStudentsClass() {
        return studentsClass;
    }

    public int getPeopleCount() {
        return peopleCount;
    }
}
