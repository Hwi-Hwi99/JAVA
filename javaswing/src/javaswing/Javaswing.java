/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaswing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.*;

public class Javaswing 
{
    public class JButtonFrameHandlerDemo extends JFrame implements ActionListener 
    {
        JLabel message;
        JLabel imgLabel;
        JTextArea textArea;
        JTextField nameTextField;
        JButton clickedButton;
        JButton cancelButton;
        JScrollPane scrollText;
        Container contentPane;

        public JButtonFrameHandlerDemo() 
        {
            contentPane = getContentPane();
            contentPane.setLayout(null);
            
            message = new JLabel("Hello JAVA");
            message.setBounds(200, 10, 150, 30);
            message.setFont(new Font("Courier", Font.BOLD, 20));
            contentPane.add(message);
            
            //imgLabel = new JLabel("Please enter your name");
            imgLabel = new JLabel("Please enter your name");               
            //imgLabel.setIcon(new ImageIcon(getClass().getResource("/javaswing/1.png")));
            ImageIcon originalIcon = new ImageIcon(getClass().getResource("/javaswing/1.png")); 
            Image img = originalIcon.getImage();
            Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImg);
            imgLabel.setIcon(scaledIcon);
            //imgLabel.setBounds(50, 50, 300, 100);
            imgLabel.setBounds(50, 50, 300, 100);  
            //contentPane.add(imgLabel);
            contentPane.add(imgLabel);                                                  

            textArea = new JTextArea();
            scrollText = new JScrollPane(textArea);
            scrollText.setBounds(20, 300, 300, 100);
            contentPane.add(scrollText);

            nameTextField = new JTextField();
            nameTextField.setBounds(20, 200, 250, 30);
            contentPane.add(nameTextField);

            clickedButton = new JButton("OK_Click");
            clickedButton.setBounds(20, 250, 100, 30);
            contentPane.add(clickedButton);
            
            cancelButton = new JButton("Cancel");
            cancelButton.setBounds(150, 250, 100, 30);
            contentPane.add(cancelButton);

            clickedButton.addActionListener(this);
            cancelButton.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if (e.getSource() == clickedButton) 
            {
                String buttonText = clickedButton.getText();
                this.setTitle("You clicked " + buttonText);
                JOptionPane.showMessageDialog(null, "You Clicked " + clickedButton.getText());
            }
            if (e.getSource() == cancelButton) 
            {
                String buttonText = cancelButton.getText();
                this.setTitle("You clicked " + buttonText);
            }
        }
    }

    public static void main(String[] args) 
    {
        JButtonFrameHandlerDemo frame = new Javaswing().new JButtonFrameHandlerDemo();
        frame.setTitle("HELLO JAVA SWING - ActionListener Interface");
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setBounds(500, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}