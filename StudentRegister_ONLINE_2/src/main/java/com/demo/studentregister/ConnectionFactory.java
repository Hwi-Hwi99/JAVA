/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.studentregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory 
{
    public static Connection getConnection()
    {
        Connection c = null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                                    + "databaseName = student;"
                                    + "user = SA;"
                                    + "password = Huy010399;"
                                    + "encrypt = true;"
                                    + "trustServerCertificate = false;"
                                    + "hostNameInCertificate = *.database.windows.net;"
                                    + "loginTimeout = 30;";
            c = DriverManager.getConnection(connectionUrl);
        } 
        catch (ClassNotFoundException e) 
        {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        } 
        catch (SQLException e) 
        {
            System.out.println("SQLException: " + e.getMessage());
        }
        return c;
    }
}