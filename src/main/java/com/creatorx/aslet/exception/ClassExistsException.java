package com.creatorx.aslet.exception;

public class ClassExistsException extends RuntimeException {
    public ClassExistsException() {
        super("This class already exists!");
    }
}
