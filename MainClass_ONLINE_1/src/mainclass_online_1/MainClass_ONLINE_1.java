/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainclass_online_1;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.*;

public class MainClass_ONLINE_1 extends JFrame
{
    public static void main(String[] args) 
    {
        //private JPanel panel;
        //private JLabel label1;
        //private JLabel label2;
        //private JButton btn1;
        //private JButton btn2;
        MainClass_ONLINE_1 mainWindow = new MainClass_ONLINE_1();    
    }
    
    public MainClass_ONLINE_1()
    {
        JPanel panel = new JPanel(new FlowLayout());
        
        JLabel label1 = new JLabel("Button 1: ");
        panel.add(label1);
        JButton btn1 = new JButton("Click me!");
        panel.add(btn1);
        btn1.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        JOptionPane.showMessageDialog(null, "I am button 1!");
                    }
                });
        
        JLabel label2 = new JLabel("Button 2: ");
        panel.add(label2);
        JButton btn2 = new JButton("Click me!");
        panel.add(btn2);
        btn2.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        JOptionPane.showMessageDialog(null, "I am button 2!");
                    }
                });
        
        this.setContentPane(panel);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    //private class Button1Handler implements ActionListener
    //{
    //    @Override
    //    public void actionPerfromed(ActionEvent e)
    //    {
    //        btn1.setText("I am button 1");
    //        JOptionPane.showMessageDialog(null, "I am button 1")
    //    }
    //}
    //private class Button2Handler implements ActionListener
    //{
    //    @Override
    //    public void actionPerfromed(ActionEvent e)
    //    {
    //        btn2.setText("I am button 2");
    //        JOptionPane.showMessageDialog(null, "I am button 2")
    //    }
    //}
    //btn1.addActionListener(new Button1Handler());
    //btn2.addActionListener(new Button2Handler());
}
