/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabaseAndTable {

    // Azure SQL Database connection parameters
    private static final String serverName = "localhost.database.windows.net";
    private static final String databaseName = "master";
    private static final String username = "SA";
    private static final String password = "Huy010399";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Step 2: Open a connection
            String connectionUrl = String.format("jdbc:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;",
                    serverName, databaseName, username, password);
            connection = DriverManager.getConnection(connectionUrl);
            System.out.println("Connected to SQL Server");

            // Step 3: Create the database if it does not exist
            createDatabase(connection, "StudentManagement");

            // Step 4: Use the newly created database
            connection.setCatalog("StudentManagement");
            System.out.println("Using database: StudentManagement");

            // Step 5: Create table 'student' in the 'StudentManagement' database
            createStudentTable(connection);

            System.out.println("Table 'student' created successfully.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up resources
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createDatabase(Connection connection, String databaseName) throws SQLException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "CREATE DATABASE " + databaseName;
            statement.executeUpdate(sql);
            System.out.println("Database '" + databaseName + "' created successfully.");
        } catch (SQLException e) {
            // Database may already exist, handle the exception as needed
            System.out.println("Database '" + databaseName + "' already exists.");
        } finally {
            if (statement != null)
                statement.close();
        }
    }

    private static void createStudentTable(Connection connection) throws SQLException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "CREATE TABLE student (" +
                    "id INT IDENTITY(1,1) PRIMARY KEY," +
                    "name NVARCHAR(200)," +
                    "dob DATE," +
                    "gender NVARCHAR(10)," +
                    "mailid NVARCHAR(100) UNIQUE," +
                    "mobile_no NVARCHAR(12) UNIQUE," +
                    "password NVARCHAR(200)," +
                    "program NVARCHAR(100)," +
                    "branch NVARCHAR(100)," +
                    "semester INT," +
                    "add_date DATETIME DEFAULT CURRENT_TIMESTAMP" +
                    ")";
            statement.executeUpdate(sql);
        } finally {
            if (statement != null)
                statement.close();
        }
    }
}

