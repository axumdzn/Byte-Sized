package com.bytesize.customExceptions;

public class DataNotFound extends RuntimeException{
    public DataNotFound(String message){
        super(message);
    }
}
