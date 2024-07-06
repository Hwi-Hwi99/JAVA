/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

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
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.mindrot.jbcrypt.BCrypt;
import javax.swing.JFrame;

public class UpdateStudent extends JFrame 
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

    private long idStudent = 0;
    public long getIdStudent() {
        return idStudent;
    }
    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public void showDetailStudent() {
        SinhVienBusiness svBusiness = new SinhVienBusiness();
        Student objSV = svBusiness.getDetailStudent(idStudent);
        if (objSV != null) {
            nameField.setText(objSV.getName());
            String date = objSV.getDob().toString();
            JOptionPane.showMessageDialog(null, "Date of Birth is Empty: " + date);
            int intYear = Integer.valueOf(date.substring(0, 4));
            int intMonth = Integer.valueOf(date.substring(5, 7));
            int intDay = Integer.valueOf(date.substring(8, 10));
            JOptionPane.showMessageDialog(null, "intYear: " + intYear);
            JOptionPane.showMessageDialog(null, "intMonth: " + intMonth);
            JOptionPane.showMessageDialog(null, "intDay: " + intDay);

            datePicker.getModel().setDate(intYear, intMonth - 1, intDay);

            if (objSV.getGender().equals("Female")) {
                genderFemale.setSelected(true);
            } else {
                genderMale.setSelected(true);
            }
            mailIdField.setText(objSV.getMailId());
            mobileNoField.setText(objSV.getMobileNo());
            passwordField.setText(objSV.getPassword());
            rePasswordField.setText(objSV.getPassword());
            programList.setSelectedItem(objSV.getProgram());
            branchList.setSelectedItem(objSV.getBranch());
            semesterList.setSelectedItem(objSV.getSemester());
        }
    }

    public UpdateStudent() {
        message = new JLabel("Register a new Student");
        message.setFont(new Font("Courier", Font.BOLD, 20));
        nameLabel = new JLabel("Name");
        nameField = new JTextField();
        dobLabel = new JLabel("DOB");
        /* Adding JDatePicker date picker */
        UtilDateModel model = new UtilDateModel();
        model.setDate(1999, 02, 02);
        model.setSelected(true);
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new UpdateStudent.DateLabelFormatter());
        dobFormat = new JLabel("(yyyy-mm-dd)");
        genderLabel = new JLabel("Giới tính:");
        genderMale = new JRadioButton("NAM", true);
        genderFemale = new JRadioButton("NỮ");
        genderGroup = new ButtonGroup();
        genderGroup.add(genderMale);
        genderGroup.add(genderFemale);

        mailIdLabel = new JLabel("Email ID:");
        mailIdField = new JTextField();
        mobileNoLabel = new JLabel("Số ĐT:");
        mobileNoField = new JTextField();

        passwordLabel = new JLabel("Mật khẩu:");
        passwordField = new JPasswordField();
        passwordField.setEnabled(false);
        rePasswordLabel = new JLabel("Nhập lần 2:");
        rePasswordField = new JPasswordField();
        rePasswordField.setEnabled(false);
        programLabel = new JLabel("Chương trình:");
        programList = new JComboBox<String>();
        programList.addItem("ME/M Tect");
        programList.addItem("BE/B Tect");
        programList.addItem("Diploma");

        branchLabel = new JLabel("Ngành:");
        branchList = new JComboBox<String>();
        branchList.addItem("Computer Science and Engineering");
        branchList.addItem("Electronics and Telecommunications");
        branchList.addItem("Information Technology");
        branchList.addItem("Electrical Engineering");
        branchList.addItem("Electrical and Electronics Engineering");
        branchList.addItem("Civil Engineering");
        semesterLabel = new JLabel("Học kỳ");
        semesterList = new JComboBox<>();
        for (int i = 1; i <= 8; i++) {
            semesterList.addItem(i);
        }
        registerButton = new JButton("Update");
        container = getContentPane();
        container.setLayout(null);
        setBounds();
        addComponents();

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.setText("Update Button is clicked here");
                JOptionPane.showMessageDialog(null, "idStudent = " + idStudent);
                System.out.println("Register Button Clicked");
                String gender = null;
                if (genderFemale.isSelected()) {
                    gender = "Female";
                } else if (genderMale.isSelected()) {
                    gender = "Male";
                }
                String programName = programList.getSelectedItem().toString();
                String branchName = branchList.getSelectedItem().toString();
                int semesterNo = Integer.parseInt(semesterList.getSelectedItem().toString());
                String dobString = datePicker.getJFormattedTextField().getText();
                if (dobString.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Date of Birth is Empty");
                    return;
                }
                Date dob = null;
                try {
                    dob = Date.valueOf(dobString);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Exception: " + ex);
                    JOptionPane.showMessageDialog(null, "Date of birth format is incorrect");
                    return;
                }
                System.out.println("name: " + nameField.getText() + ", dob: " + dobString
                        + ", gender: " + gender + ", mailid: " + mailIdField.getText()
                        + ", mobileNo: " + mobileNoField.getText() + ", password: " + passwordField.getText()
                        + ", rePassword: " + rePasswordField.getText() + ", branch: " + branchName
                        + ", semester: " + semesterNo);
                Student student = new Student(idStudent, nameField.getText(), dob, gender, mailIdField.getText(), 
                        mobileNoField.getText(), programName, branchName, semesterNo);

                ValidationUpdateStudent v = new ValidationUpdateStudent();
                java.util.List<String> errors = v.validateUpdateStudent(student);
                if (errors.size() > 0) {
                    JOptionPane.showMessageDialog(null, errors.toArray());
                    return;
                } else {
                    SinhVienBusiness svBusiness = new SinhVienBusiness();
                    boolean kq = false;

                    if (idStudent != 0) {
                        kq = svBusiness.updateStudent(student);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "idStudent = 0, không thể cập nhật");
                    }
                    if (kq) {
                        JOptionPane.showMessageDialog(rootPane, "UPDATE SUCCESS!");
                    }
                    frmDanhSachSinhVien.showStudentList();
                }
            }
        });
    }
    
    public void setBounds() 
    {
        message.setBounds(50, 10, 600, 30);
        
        nameLabel.setBounds(50, 60, 100, 30);
        nameField.setBounds(150, 60, 250, 30);
        
        dobLabel.setBounds(50, 110, 100, 30);
        /*JDatePicker*/
        datePicker.setBounds(150, 110, 200, 30);
        dobFormat.setBounds(360, 110, 200, 30);
        
        genderLabel.setBounds(50, 160, 100, 30);
        genderMale.setBounds(150, 160, 100, 30);
        genderFemale.setBounds(240, 160, 100, 30);
        
        mailIdLabel.setBounds(50, 210, 100, 30);
        mailIdField.setBounds(150, 210, 250, 30);
        mobileNoLabel.setBounds(50, 260, 100, 30);
        mobileNoField.setBounds(150, 260, 250, 30);
        
        passwordLabel.setBounds(50, 310, 100, 30);
        passwordField.setBounds(150, 310, 250, 30);
        rePasswordLabel.setBounds(50, 360, 100, 30);
        rePasswordField.setBounds(150, 360, 250, 30);
        
        programLabel.setBounds(50, 410, 100, 30);
        programList.setBounds(150, 410, 150, 30);
        branchLabel.setBounds(50, 460, 100, 30);
        branchList.setBounds(150, 460, 250, 30);
        semesterLabel.setBounds(50, 510, 100, 30);
        semesterList.setBounds(150, 510, 100, 30);
        
        registerButton.setBounds(150, 600, 150, 30);
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
    
    /*JDate Picker drop down*/
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
