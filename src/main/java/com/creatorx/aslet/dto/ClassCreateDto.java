package com.creatorx.aslet.dto;

import jakarta.validation.constraints.*;

public class ClassCreateDto {
    @NotNull
    @Min(value = 1, message = "min grade is 1")
    @Max(value = 12, message = "max grade is 12")
    private int grade;
    @NotNull
    private char letter;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }
}
