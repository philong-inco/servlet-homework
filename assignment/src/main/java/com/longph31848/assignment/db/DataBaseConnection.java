package com.longph31848.assignment.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/servlet_assignment";
    private static final String USERNAME = "springstudent";
    private static final String PASSWORD = "springstudent";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        if (connection == null){
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }

}
