package com.creatorx.aslet.exception;

public class NotAuthorizedException extends RuntimeException {
    public NotAuthorizedException() {
        super("You are not authorized to access this resource!");
    }
}
