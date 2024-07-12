/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;
//Add thêm các thư viện như JBCrypt và mssql
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.mindrot.jbcrypt.BCrypt;

public class LAB9 extends JFrame implements ActionListener {

    JLabel userNameLable, passwordLabel;
    JTextField userNameTextField;
    JPasswordField passwordField;
    JButton loginButton;
    Container container;

    public LAB9() {
        userNameLable = new JLabel("User Name");
        userNameTextField = new JTextField();
        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        container = getContentPane();
        container.setLayout(null);
        setBounds();
        addComponents();
        addActionListener();
    }

    public void setBounds() {
        userNameLable.setBounds(10, 10, 100, 30);
        userNameTextField.setBounds(100, 10, 200, 30);
        passwordLabel.setBounds(10, 50, 100, 30);
        passwordField.setBounds(100, 50, 200, 30);
        loginButton.setBounds(100, 100, 200, 30);
    }

    public void addComponents() {
        container.add(userNameLable);
        container.add(userNameTextField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(loginButton);
    }

    public void addActionListener() {
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Event called");
        if (e.getSource() == loginButton) {
            String userName = userNameTextField.getText();
            /*never print password or other sensitive data in console
        this is only for testing purpose*/
            String password = passwordField.getText();
            System.out.println(userName + " " + password);
            Validation v = new Validation();
            java.util.List<String> errors = v.validateLogin(userName, password);
            if (errors.size() > 0) {
                JOptionPane.showMessageDialog(null, errors.toArray());
                return;
            }
            
            LoginDAO dao = new LoginDAO();
            Student student = dao.checkLogin(userName);
            System.out.println(student);
            if (student.getId() == 0) {
                System.out.println("No user found with username");
                return;
            } else {
                // check password provided by user with stored password in database
                if (BCrypt.checkpw(password, student.getPassword())) {
                    System.out.println("Logged in");
                    new HomeFrame().setVisible(true);
                    this.dispose();
                } else {
                    System.out.println("Unable to login");
                    JOptionPane.showMessageDialog(null, "User id or password is incorrect");
                }
            }
            //check password provided by user with stored password in database
            if (userName.equalsIgnoreCase("Test")
                    && password.equalsIgnoreCase("1234@.")) {
                System.out.println("Logged in");
            } else {
                System.out.println("Unable to login");
            }
        }
    }

    public static void main(String[] args) {
        LAB9 frame = new LAB9();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(250, 250, 370, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
