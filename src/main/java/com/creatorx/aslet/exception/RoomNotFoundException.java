package com.creatorx.aslet.exception;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(Long id) {
        super("Room not found with id " + id + "! Try again with other id.");
    }
}
