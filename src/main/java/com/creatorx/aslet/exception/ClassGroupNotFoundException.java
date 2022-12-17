package com.creatorx.aslet.exception;

public class ClassGroupNotFoundException extends RuntimeException {
    public ClassGroupNotFoundException(Long id) {
        super("Class group not found with id " + id + "! Try again with other id.");
    }
}
