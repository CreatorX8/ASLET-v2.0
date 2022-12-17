package com.creatorx.aslet.advice;

import com.creatorx.aslet.exception.ClassGroupNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ClassGroupControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ClassGroupNotFoundException.class)
    public Map<String, String> handleClassGroupsException(ClassGroupNotFoundException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("status", "404");
        errorMap.put("error", exception.getMessage());
        return errorMap;
    }
}
