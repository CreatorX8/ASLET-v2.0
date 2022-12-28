package com.creatorx.aslet.advice;

import com.creatorx.aslet.exception.NotAuthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class NotAuthorizedAdvice {
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(NotAuthorizedException.class)
    public Map<String, String> handleNotAuthorizedException(NotAuthorizedException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("status", "401");
        errorMap.put("error", exception.getMessage());
        return errorMap;
    }
}
