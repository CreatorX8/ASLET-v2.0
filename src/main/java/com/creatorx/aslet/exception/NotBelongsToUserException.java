package com.creatorx.aslet.exception;

public class NotBelongsToUserException extends RuntimeException {
    public NotBelongsToUserException() {
        super("This resource does not belong to you!");
    }
}
