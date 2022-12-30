package com.creatorx.aslet.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class HourCreateDto {
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

    public Long getClassGroup() {
        return classGroup;
    }

    public void setClassGroup(Long classGroup) {
        this.classGroup = classGroup;
    }

    public Long getTeacher() {
        return teacher;
    }

    public void setTeacher(Long teacher) {
        this.teacher = teacher;
    }

    public Long getSubject() {
        return subject;
    }

    public void setSubject(Long subject) {
        this.subject = subject;
    }

    public Integer getHoursAWeek() {
        return hoursAWeek;
    }

    public void setHoursAWeek(Integer hoursAWeek) {
        this.hoursAWeek = hoursAWeek;
    }
}
