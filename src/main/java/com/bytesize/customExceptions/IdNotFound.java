package com.bytesize.customExceptions;

public class IdNotFound extends RuntimeException{
    public IdNotFound(String message){
        super(message);
    }
}