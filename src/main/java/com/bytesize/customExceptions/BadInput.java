package com.bytesize.customExceptions;

public class BadInput extends RuntimeException{
    public BadInput(String message) {
        super(message);
    }
}
