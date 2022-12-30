package com.creatorx.aslet.exception;

public class HourNotFoundException extends RuntimeException {
    public HourNotFoundException(Long id) {
        super("Hour not found with id " + id + "! Try again with other id.");
    }
}
