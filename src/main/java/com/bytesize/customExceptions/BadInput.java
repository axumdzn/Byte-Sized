package com.bytesize.customExceptions;

import java.sql.SQLException;

public class BadInput extends RuntimeException{
    public BadInput(String message) {
        super(message);
    }
}
