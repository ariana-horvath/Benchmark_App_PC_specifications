package view;

import model.MultithreadTestModel;

import javax.swing.*;
import java.awt.*;

public class MultithreadTestGUI extends JFrame {
    private JButton exitButton;
    private MultithreadTestModel multithreadTest;

    public MultithreadTestGUI(MultithreadTestModel multithreadTest) {
        this.multithreadTest = multithreadTest;
        this.setTitle("Multithreading Test");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.setLocationRelativeTo(null);
        initializeForm(panel);
        this.setContentPane(panel);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(140, 246, 187));
    }

    public void initializeForm(JPanel panel) {
        JLabel title = new JLabel("Multithreading Test: Counting the Vowels in a Text");
        title.setFont(new Font("Calibri", Font.BOLD, 20));
        title.setForeground(new Color(2, 95, 69, 255));
        title.setBounds(25, 20, 500, 30);
        panel.add(title);

        JLabel description = new JLabel("<html>&emsp;A random text of 1.000.000 characters is given and the vowels from " +
                "it are <br> counted. The text is split between 1, 2, 4, 8, 16 or 32 threads." +
                "<br>&emsp; These operations are repeated 1000 times for each number of threads.</html>");
        description.setFont(new Font("Calibri", Font.PLAIN, 14));
        description.setForeground(new Color(2, 95, 69, 255));
        description.setBounds(10, 50, 500, 100);
        panel.add(description);

        JLabel execTimeLabel = new JLabel("Execution Time (in milliseconds):");
        execTimeLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        execTimeLabel.setForeground(new Color(2, 95, 69, 255));
        execTimeLabel.setBounds(10, 150, 500, 30);
        panel.add(execTimeLabel);

        JLabel execTime1Label = new JLabel("1 thread:");
        execTime1Label.setFont(new Font("Calibri", Font.BOLD, 14));
        execTime1Label.setForeground(new Color(2, 95, 69, 255));
        execTime1Label.setBounds(50, 180, 500, 30);
        panel.add(execTime1Label);

        JLabel execTime1 = new JLabel(Integer.toString(multithreadTest.getExecutionTime1()));
        execTime1.setFont(new Font("Calibri", Font.BOLD, 14));
        execTime1.setForeground(new Color(2, 95, 69, 255));
        execTime1.setBounds(140, 180, 400, 30);
        panel.add(execTime1);

        JLabel execTime2Label = new JLabel("2 threads:");
        execTime2Label.setFont(new Font("Calibri", Font.BOLD, 14));
        execTime2Label.setForeground(new Color(2, 95, 69, 255));
        execTime2Label.setBounds(50, 210, 500, 30);
        panel.add(execTime2Label);

        JLabel execTime2 = new JLabel(Integer.toString(multithreadTest.getExecutionTime2()));
        execTime2.setFont(new Font("Calibri", Font.BOLD, 14));
        execTime2.setForeground(new Color(2, 95, 69, 255));
        execTime2.setBounds(140, 210, 400, 30);
        panel.add(execTime2);

        JLabel execTime3Label = new JLabel("4 threads:");
        execTime3Label.setFont(new Font("Calibri", Font.BOLD, 14));
        execTime3Label.setForeground(new Color(2, 95, 69, 255));
        execTime3Label.setBounds(50, 240, 500, 30);
        panel.add(execTime3Label);

        JLabel execTime4 = new JLabel(Integer.toString(multithreadTest.getExecutionTime4()));
        execTime4.setFont(new Font("Calibri", Font.BOLD, 14));
        execTime4.setForeground(new Color(2, 95, 69, 255));
        execTime4.setBounds(140, 240, 400, 30);
        panel.add(execTime4);

        JLabel execTime8Label = new JLabel("8 threads:");
        execTime8Label.setFont(new Font("Calibri", Font.BOLD, 14));
        execTime8Label.setForeground(new Color(2, 95, 69, 255));
        execTime8Label.setBounds(50, 270, 500, 30);
        panel.add(execTime8Label);

        JLabel execTime8 = new JLabel(Integer.toString(multithreadTest.getExecutionTime8()));
        execTime8.setFont(new Font("Calibri", Font.BOLD, 14));
        execTime8.setForeground(new Color(2, 95, 69, 255));
        execTime8.setBounds(140, 270, 400, 30);
        panel.add(execTime8);

        JLabel execTime16Label = new JLabel("16 threads:");
        execTime16Label.setFont(new Font("Calibri", Font.BOLD, 14));
        execTime16Label.setForeground(new Color(2, 95, 69, 255));
        execTime16Label.setBounds(50, 300, 500, 30);
        panel.add(execTime16Label);

        JLabel execTime16 = new JLabel(Integer.toString(multithreadTest.getExecutionTime16()));
        execTime16.setFont(new Font("Calibri", Font.BOLD, 14));
        execTime16.setForeground(new Color(2, 95, 69, 255));
        execTime16.setBounds(140, 300, 400, 30);
        panel.add(execTime16);

        JLabel execTime32Label = new JLabel("32 threads:");
        execTime32Label.setFont(new Font("Calibri", Font.BOLD, 14));
        execTime32Label.setForeground(new Color(2, 95, 69, 255));
        execTime32Label.setBounds(50, 330, 500, 30);
        panel.add(execTime32Label);

        JLabel execTime32 = new JLabel(Integer.toString(multithreadTest.getExecutionTime32()));
        execTime32.setFont(new Font("Calibri", Font.BOLD, 14));
        execTime32.setForeground(new Color(2, 95, 69, 255));
        execTime32.setBounds(140, 330, 400, 30);
        panel.add(execTime32);

        exitButton = new JButton("Exit");
        exitButton.setBounds(140, 400, 210, 30);
        exitButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        exitButton.setForeground(new Color(2, 95, 69, 255));
        panel.add(exitButton);
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
