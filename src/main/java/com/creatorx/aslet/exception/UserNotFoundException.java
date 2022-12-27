package com.creatorx.aslet.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User not found with id " + id + "! Try again with other id.");
    }

    public UserNotFoundException() {
        super("Wrong email or password! Try again with correct email and password.");
    }
}
