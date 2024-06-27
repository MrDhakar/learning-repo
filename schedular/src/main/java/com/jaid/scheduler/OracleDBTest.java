package com.jaid.scheduler;

import java.sql.*;
import java.util.Properties;

public class OracleDBTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String jdbcUrl = "jdbc:oracle:thin:@//localhost:1521/orcl.Nagarro.local";
        String username = "sys as sysdba";
        String password = "Jaid@123";


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
