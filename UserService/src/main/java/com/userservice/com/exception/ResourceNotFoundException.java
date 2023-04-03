package com.userservice.com.exception;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(){
        super("Resources not fond on server !!");
    }

    public  ResourceNotFoundException(String message){
        super(message);
    }
}
