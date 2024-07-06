/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAO 
{
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;
    
    public int registerStudent(Student student) 
    {
        con = ConnectionFactory.getConnection();
        if (con == null) 
        {
            System.out.println("Failed to make connection!");
            return -1;
        }
        try 
        {
            // Kiểm tra xem email đã tồn tại chưa
            String checkQuery = "SELECT COUNT(*) FROM student WHERE mailid = ?";
            ps = con.prepareStatement(checkQuery);
            ps.setString(1, student.getMailId());
            rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Email này đã tồn tại!");
                return -1;
            }
            
            Timestamp addDate = new Timestamp(System.currentTimeMillis());
            // Nếu email chưa tồn tại, thêm mới sinh viên
            String query = "INSERT INTO student "
                    + "(name, dob, gender, mailid, mobile_no, password, program, branch, semester) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setDate(2, student.getDob());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getMailId());
            ps.setString(5, student.getMobileNo());
            ps.setString(6, student.getEncPassword());
            ps.setString(7, student.getProgram());
            ps.setString(8, student.getBranch());
            ps.setInt(9, student.getSemester());
            
            st = ps.executeUpdate();
            System.out.println("Inserted student: " + st);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            st = -2;
        } 
        finally 
        {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
        return st;
    }
}