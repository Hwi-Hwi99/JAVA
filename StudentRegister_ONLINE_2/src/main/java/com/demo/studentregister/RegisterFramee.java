/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.demo.studentregister;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.sql.Date;
//import java.sql.Timestamp;
//imports for JDatePicker
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.DateLabelFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.mindrot.jbcrypt.BCrypt;

public class RegisterFramee extends JFrame 
{
    JLabel message;
    JLabel nameLabel, dobLabel, genderLabel, dobFormat;
    JTextField nameField;
    JRadioButton genderMale, genderFemale;
    ButtonGroup genderGroup;
    JLabel mailIdLabel, mobileNoLabel;
    JTextField mailIdField, mobileNoField;
    JLabel passwordLabel, rePasswordLabel;
    JPasswordField passwordField, rePasswordField;
    JLabel programLabel;
    JComboBox<String> programList;
    JLabel branchLabel, semesterLabel;
    JComboBox<String> branchList;
    JComboBox<Integer> semesterList;
    JButton registerButton;
    Container container;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker;

    public RegisterFramee() 
    {
        message = new JLabel("Register a new Student");
        message.setFont(new Font("Courier", Font.BOLD, 20));
        nameLabel = new JLabel("Name");
        nameField = new JTextField();
        dobLabel = new JLabel("DOB");
        
        /* Adding JDatePicker date picker */
        UtilDateModel model = new UtilDateModel();
        model.setDate(1999, 01, 02);
        model.setSelected(true);
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        dobFormat = new JLabel("(yyyy-mm-dd)");
        /* End Date picker */
        
        genderLabel = new JLabel("Gender");
        genderMale = new JRadioButton("Male", true);
        genderFemale = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(genderMale);
        genderGroup.add(genderFemale);
        
        mailIdLabel = new JLabel("Mail Id");
        mailIdField = new JTextField();
        mobileNoLabel = new JLabel("Mobile No");
        mobileNoField = new JTextField();
        
        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();
        rePasswordLabel = new JLabel("Re Password");
        rePasswordField = new JPasswordField();
        
        programLabel = new JLabel("Courses");
        programList = new JComboBox<String>();
        programList.addItem("ME/M Tect");
        programList.addItem("BE/B Tect");
        programList.addItem("Diploma");
        
        branchLabel = new JLabel("Branch");
        branchList = new JComboBox<String>();
        branchList.addItem("Computer Science and Engineering");
        branchList.addItem("Electronics and Telecommunications");
        branchList.addItem("Information Technology");
        branchList.addItem("Electrical Engineering");
        branchList.addItem("Electrical and Electronics Engineering");
        branchList.addItem("Civil Engineering");
        semesterLabel = new JLabel("Semester");
        semesterList = new JComboBox<>();
        for (int i = 1; i <= 8; i++) 
        {
            semesterList.addItem(i);
        }
        registerButton = new JButton("Register");
        container = getContentPane();
        container.setLayout(null);
        setBounds();
        addComponents();
        
        registerButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                message.setText("Ok Button is clicked here");
                System.out.println("Register Button Clicked");
                String gender = null;
                if (genderFemale.isSelected()) 
                {
                    gender = "Female";
                } else if (genderMale.isSelected()) 
                {
                    gender = "Male";
                }
                String programName = programList.getSelectedItem().toString();
                String branchName = branchList.getSelectedItem().toString();
                int semesterNo = Integer.parseInt(semesterList.getSelectedItem().toString());
                String dobString = datePicker.getJFormattedTextField().getText();
                if (dobString.isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "Date of Birth is Empty");
                    return;
                }
                Date dob = null;
                try 
                {
                    dob = Date.valueOf(dobString);
                } catch (IllegalArgumentException ex) 
                {
                    System.out.println("Exception: " + ex);
                    JOptionPane.showMessageDialog(null, "Date of birth format is incorrect");
                    return;
                }
                System.out.println("name: " + nameField.getText() + ", dob: " + dobString
                        + ", gender: " + gender + ", mailid: " + mailIdField.getText()
                        + ", mobileNo: " + mobileNoField.getText() + ", password: " + passwordField.getText()
                        + ", rePassword: " + rePasswordField.getText() + ", branch: " + branchName
                        + ", semester: " + semesterNo);
                Student student = new Student(nameField.getText(), dob, gender, mailIdField.getText(), mobileNoField.getText(), passwordField.getText(), programName, branchName, semesterNo);
                student.setEncPassword(BCrypt.hashpw(student.getPassword(), BCrypt.gensalt()));
                
                Validation v = new Validation();
                java.util.List<String> errors = v.validateRegistration(student);
                if (errors.size() > 0) 
                {
                    JOptionPane.showMessageDialog(null, errors.toArray());
                    return;
                } 
                else 
                {
                    RegisterDAO dao = new RegisterDAO();
                    int st = 0;
                    System.out.println(st);
                    st = dao.registerStudent(student);
                    if (st == 1) {
                        JOptionPane.showMessageDialog(null, "Registered Successfully");
                    }
                    if (st == -1) {
                        JOptionPane.showMessageDialog(null, "Already Registered");
                    }
                    if (st == -2) {
                        JOptionPane.showMessageDialog(null, "Oops Unable to Register");
                    }
                }
            }           
        });
    }

    public void setBounds() 
    {
        message.setBounds(50, 10, 600, 30);
        nameLabel.setBounds(50, 60, 100, 30);
        nameField.setBounds(130, 60, 200, 30);
        dobLabel.setBounds(50, 110, 100, 30);
        /*JDatePicker*/
        datePicker.setBounds(130, 110, 200, 30);
        dobFormat.setBounds(350, 110, 200, 30);
        genderLabel.setBounds(50, 160, 100, 30);
        genderMale.setBounds(130, 160, 100, 30);
        genderFemale.setBounds(240, 160, 100, 30);
        mailIdLabel.setBounds(50, 210, 100, 30);
        mailIdField.setBounds(130, 210, 200, 30);
        mobileNoLabel.setBounds(50, 260, 100, 30);
        mobileNoField.setBounds(130, 260, 200, 30);
        passwordLabel.setBounds(50, 310, 100, 30);
        passwordField.setBounds(130, 310, 200, 30);
        rePasswordLabel.setBounds(50, 360, 100, 30);
        rePasswordField.setBounds(130, 360, 200, 30);
        programLabel.setBounds(50, 410, 100, 30);
        programList.setBounds(130, 410, 200, 30);
        branchLabel.setBounds(50, 460, 100, 30);
        branchList.setBounds(130, 460, 200, 30);
        semesterLabel.setBounds(50, 510, 100, 30);
        semesterList.setBounds(130, 510, 200, 30);
        registerButton.setBounds(130, 550, 200, 30);
    }

    public void addComponents() 
    {
        container.add(message);
        container.add(nameLabel);
        container.add(nameField);
        container.add(dobLabel);
        /*JDatePicker*/
        container.add(datePicker);
        container.add(dobFormat);
        container.add(genderLabel);
        container.add(genderMale);
        container.add(genderFemale);
        container.add(mailIdLabel);
        container.add(mailIdField);
        container.add(mobileNoLabel);
        container.add(mobileNoField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(rePasswordLabel);
        container.add(rePasswordField);
        container.add(programLabel);
        container.add(programList);
        container.add(branchLabel);
        container.add(branchList);
        container.add(semesterLabel);
        container.add(semesterList);
        container.add(registerButton);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) 
    {    
        System.out.println("abc");
        RegisterFramee frame = new RegisterFramee();
        frame.setTitle("Student Register Form");
        frame.setVisible(true);
        frame.setBounds(500, 100, 500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    
    public class DateLabelFormatter extends AbstractFormatter 
    {
        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException 
        {
            return dateFormatter.parseObject(text);
        }
        @Override
        public String valueToString(Object value) throws ParseException 
        {
            if (value != null) 
            {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }
            return "";
        }
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

