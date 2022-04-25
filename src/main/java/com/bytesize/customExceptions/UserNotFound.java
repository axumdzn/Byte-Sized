package com.bytesize.customExceptions;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String message)
    { super(message); }
}
