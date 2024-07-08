package com.jaid.gateway;

import java.sql.*;
import java.util.Properties;

public class OracleDBTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String jdbcUrl = "jdbc:oracle:thin:@//localhost:1521/aotdb";
        String username = "sys as sysdba";
        String password = "Edge@123#";


        // Register the PostgreSQL driver

        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Connect to the database
        
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        Statement statement = connection.createStatement();

        // Execute a query to retrieve rows from sample_table
        String query = "SELECT * FROM USERS";
        ResultSet resultSet = statement.executeQuery(query);

        // Perform desired database operations
        
        // Close the connection
        connection.close();
    }
}
