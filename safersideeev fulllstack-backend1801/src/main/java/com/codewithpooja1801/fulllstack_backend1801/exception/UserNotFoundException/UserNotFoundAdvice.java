package com.codewithpooja1801.fulllstack_backend1801.exception.UserNotFoundException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


public class UserNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(UserNotFoundsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
public Map<String , String> exceptionHandler(UserNotFoundsException exception){
    Map<String , String> errorMap=new HashMap<>();
    errorMap.put("errorMessage", exception.getMessage());
    return errorMap;
}
}
