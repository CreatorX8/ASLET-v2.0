package com.creatorx.aslet.exception;

public class UserNotApprovedException extends RuntimeException {
    public UserNotApprovedException() {
        super("Your account is not approved yet. Please wait for the administrator to approve your account.");
    }
}
