/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

import java.sql.SQLIntegrityConstraintViolationException;
//import java.lang.ArrayIndexOutOfBoundsException;
//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SinhVienBusiness {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;

    public List<Student> getStudentList() {
        List<Student> lstStudent = new ArrayList<>();
        con = ConnectionFactory.getConnection();
        try {
            String query = "SELECT id, name, dob, gender, mailid, password, mobile_no, program, branch, semester FROM student";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            Student student = null;
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setDob(rs.getDate("dob"));
                student.setGender(rs.getString("gender"));
                student.setMailId(rs.getString("mailid"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setPassword(rs.getString("password"));
                student.setProgram(rs.getString("program"));
                student.setBranch(rs.getString("branch"));
                student.setSemester(rs.getInt("semester"));
                lstStudent.add(student);
            }
            
            System.out.println("SELECT * FROM student" + st);
        } catch (SQLException ex) {
            System.out.println("Failed to make connection with SQL!"
                                + "Detail: " + ex.getMessage());
            st = -1;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                st = -2;
            }
        }
        return lstStudent;
    }

    public Student getDetailStudent(long id) {
        Student student = null;
        con = ConnectionFactory.getConnection();
        try {
            String query = "SELECT * FROM student WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setDob(rs.getDate("dob"));
                student.setGender(rs.getString("gender"));
                student.setMailId(rs.getString("mailid"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setUname(rs.getString("mobile_no"));
                student.setPassword(rs.getString("password"));
                student.setProgram(rs.getString("program"));
                student.setBranch(rs.getString("branch"));
                student.setSemester(rs.getInt("semester"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return student;
    }

    public boolean updateStudent(Student student) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "UPDATE student SET name = ?, dob = ?, gender = ?, mailid = ?, mobile_no = ?, program = ?, branch = ?, semester = ? WHERE id = ?";
            ps = con.prepareStatement(query);
            
            ps.setString(1, student.getName());
            ps.setDate(2, student.getDob());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getMailId());
            ps.setString(5, student.getMobileNo());
            ps.setString(6, student.getProgram());
            ps.setString(7, student.getBranch());
            ps.setInt(8, student.getSemester());
            ps.setLong(9, student.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public int registerStudent(Student student) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "INSERT INTO "
                    + "student "
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
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            st = -1;
        } catch (SQLException e) {
            e.printStackTrace();
            st = -2;
        }
        return st;
    }

    public boolean deleteStudent(long id) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "DELETE FROM student WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}

