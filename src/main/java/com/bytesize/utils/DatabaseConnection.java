package com.bytesize.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection createConnection() {
        try{
//            "jdbc:postgresql://url:port/databasetype?user=username&password=actualpassword"
            Connection connection = DriverManager.getConnection(String.format("jdbc:postgresql://%s:%s/%s?user=%s&password=%s",
                    System.getenv("HOST"),
                    System.getenv("PORT"),
                    System.getenv("DB"),
                    System.getenv("USER"),
                    System.getenv("PASSWORD")
            ));
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(createConnection());
    }
}

