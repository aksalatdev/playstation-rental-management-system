/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pleystation.model.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aksal
 */
class DBConnection {
    private String connectionURL = "jdbc:mysql:///pleystation?useSSL=false";
    private String dbUsername = "root";
    private String dbPassword = "";

    private java.sql.Connection connection;
    protected PreparedStatement statement;
    protected ResultSet resultSet;
    
    protected DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL,
                    dbUsername,
                    dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
    
    protected Connection getConnection() {
        return connection;
    }
}
