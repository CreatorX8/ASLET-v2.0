package com.creatorx.aslet.exception;

public class UserExistsException extends RuntimeException {
    public UserExistsException() {
        super("User with this email already exists!");
    }
}
