/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Time extends JFrame
{ 
    private final JLabel timeLabel;
    private int timeLeft;

    public Time() 
    {
        setTitle("Pacman Game with Timer");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        timeLeft = 300; // 60 giây
        timeLabel = new JLabel("Time left: " + timeLeft, JLabel.CENTER);
        add(timeLabel, BorderLayout.NORTH);

        startTimer();
    }

    private void startTimer() 
    {
        Timer timer = new Timer(1000, new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timeLabel.setText("Time left: " + timeLeft);

                if (timeLeft <= 0) {
                    ((Timer) e.getSource()).stop();
                    gameOver();
                }
            }
        });
        timer.start();
    }

    private void gameOver() 
    {
        JOptionPane.showMessageDialog(this, "Time's up! Game Over!");
        System.exit(0);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() {
                new Time().setVisible(true);
            }
        });
    }
}
