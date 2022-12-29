package com.creatorx.aslet.dto;

import jakarta.validation.constraints.*;

public class RoomCreateDto {
    @NotEmpty
    @Size(min = 1, max = 10, message = "name must be between 1 and 10 characters long")
    private String name;

    @NotNull
    @Min(value = 1, message = "min capacity is 1")
    @Max(value = 100, message = "max capacity is 100")
    private Integer capacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
