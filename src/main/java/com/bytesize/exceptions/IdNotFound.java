package com.bytesize.exceptions;

public class IdNotFound extends RuntimeException //unchecked exception-can determine where/when to handle the exception
{

    public IdNotFound(String message)
    {
        super(message);
    }
    public static void main(String[] args)
    {
        throw new IdNotFound("ID not found");
    }
}
