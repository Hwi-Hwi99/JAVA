/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

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
            //String connectionUrl = "jdbc:sqlserver://localhost.database.windows.net:1433;"
            String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                     + "databaseName=StudentManagement;"
                     + "user=SA;"
                     + "password=Huy010399;"
                     + "encrypt=true;"
                     + "trustServerCertificate=true;";
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