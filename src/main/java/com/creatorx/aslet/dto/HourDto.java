package com.creatorx.aslet.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class HourDto {
    private Long id;
    @NotNull
    private Long classGroup;
    @NotNull
    private Long teacher;
    @NotNull
    private Long subject;
    @NotNull
    @Min(value = 1, message = "min hours a week is 1")
    @Max(value = 15, message = "max hours a week is 15")
    private Integer hoursAWeek;

    public HourDto(Long id, Long classGroup, Long teacher, Long subject, Integer hoursAWeek) {
        this.id = id;
        this.classGroup = classGroup;
        this.teacher = teacher;
        this.subject = subject;
        this.hoursAWeek = hoursAWeek;
    }

    public Long getId() {
        return id;
    }

    public Long getClassGroup() {
        return classGroup;
    }

    public Long getTeacher() {
        return teacher;
    }

    public Long getSubject() {
        return subject;
    }

    public Integer getHoursAWeek() {
        return hoursAWeek;
    }
}
