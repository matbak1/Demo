package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestConnection {


    public static void testConnection(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:file:~/test","sa", "");
            System.out.println("Connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
