package com.creatorx.aslet.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User not found with id " + id + "! Try again with other id.");
    }
}
