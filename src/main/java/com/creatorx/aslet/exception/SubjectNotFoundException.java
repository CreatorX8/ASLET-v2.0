package com.creatorx.aslet.exception;

public class SubjectNotFoundException extends RuntimeException {
    public SubjectNotFoundException(Long id) {
        super("Subject not found with id " + id + "! Try again with other id.");
    }
}
