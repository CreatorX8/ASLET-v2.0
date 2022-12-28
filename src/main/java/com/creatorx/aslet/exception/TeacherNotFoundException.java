package com.creatorx.aslet.exception;

public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(Long id) {
        super("Teacher not found with id " + id + "! Try again with other id.");
    }
}
