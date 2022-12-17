package com.creatorx.aslet.exception;

public class ClassNotFoundException extends RuntimeException {
    public ClassNotFoundException(Long id) {
        super("Class not found with id " + id + "! Try again with other id.");
    }
}
