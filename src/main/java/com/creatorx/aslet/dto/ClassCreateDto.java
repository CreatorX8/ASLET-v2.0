package com.creatorx.aslet.dto;

import jakarta.validation.constraints.*;

public class ClassCreateDto {
    @NotNull
    @Min(value = 1, message = "min grade is 1")
    @Max(value = 12, message = "max grade is 12")
    private int grade;
    @NotNull
    private char letter;
    @NotNull
    @Min(value = 1, message = "min people count is 1")
    @Max(value = 1000, message = "max people count is 1000")
    private int peopleCount;

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

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }
}
