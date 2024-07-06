/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaswing_ltbuoi6;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class JFrameSubclass1 extends JavaSwing_LTBuoi6
{
    Container contentPane;
    JButton okButton;
    JButton cancelButton;
    
    public JFrameSubclass1 ()
    {
        //contentPane = getContentPane();
        contentPane.setBackground(Color.RED);
        contentPane.setLayout(new FlowLayout());
        okButton = new JButton();
        okButton.setText("OK");
        contentPane.add(okButton);
        cancelButton = new JButton();
        okButton.setText("Cancel");
        contentPane.add(cancelButton);
    }
}
