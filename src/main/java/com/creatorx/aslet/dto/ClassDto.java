package com.creatorx.aslet.dto;

import jakarta.validation.constraints.*;

public class ClassDto {
    private Long id;
    @NotNull
    @Min(value = 1, message = "min grade is 1")
    @Max(value = 12, message = "max grade is 12")
    private int grade;
    @NotNull
    private char letter;

    public ClassDto(Long id, int grade, char letter) {
        this.id = id;
        this.grade = grade;
        this.letter = letter;
    }

    public Long getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public char getLetter() {
        return letter;
    }
}
