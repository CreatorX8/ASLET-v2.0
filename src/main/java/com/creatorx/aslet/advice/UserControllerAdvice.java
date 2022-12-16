package com.creatorx.aslet.advice;

import com.creatorx.aslet.exception.UserExistsException;
import com.creatorx.aslet.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UserControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleUsersException(UserNotFoundException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("status", "404");
        errorMap.put("error", exception.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(UserExistsException.class)
    public Map<String, String> handleUsersException(UserExistsException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("status", "406");
        errorMap.put("error", exception.getMessage());
        return errorMap;
    }
}
