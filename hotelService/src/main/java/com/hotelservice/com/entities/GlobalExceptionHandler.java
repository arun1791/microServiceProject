package com.hotelservice.com.entities;

import com.hotelservice.com.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Objects>> notfoundHandler(ResourceNotFoundException ex){
    Map map=new HashMap();
    map.put("meassge",ex.getMessage());
    map.put("succes",false);
    map.put("status", HttpStatus.NOT_FOUND);
    return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);

    }
}
