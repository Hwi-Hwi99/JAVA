/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaswing_ltbuoi6;

import javax.swing.JFrame;
//import javax.swing.JOptionPane;

public class JavaSwing_LTBuoi6 
{
    public static void main(String[] args) 
    {
        //JOptionPane.showMessageDialog(null, "I Love JAVA");
        //JOptionPane.showMessageDialog(null, "one\ntwo\nthree");
        
        //String inputstr = JOptionPane.showInputDialog(null, "What is your name?");
        //System.out.println(inputstr);
        //JOptionPane.showMessageDialog(null, inputstr);
        
        JFrame defaultJFrame;
        defaultJFrame = new JFrame();
        defaultJFrame.setVisible(true);
        defaultJFrame.setSize(400, 400);
        defaultJFrame.setTitle("HELLO JAVA SWING");
        defaultJFrame.setAlwaysOnTop(true);
        defaultJFrame.setResizable(true);
        defaultJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
