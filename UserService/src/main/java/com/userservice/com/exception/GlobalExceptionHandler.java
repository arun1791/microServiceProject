package com.userservice.com.exception;

import com.userservice.com.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourcesNotFoundException(ResourceNotFoundException ex){
       String message= ex.getMessage();
      ApiResponse resposne= ApiResponse.builder().meassge(message).sucesss(true).status(HttpStatus.NOT_FOUND).build();
      return  new ResponseEntity<ApiResponse>(resposne ,HttpStatus.NOT_FOUND);
    }

}
