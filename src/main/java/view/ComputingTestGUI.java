package view;

import model.ComputingTestModel;

import javax.swing.*;
import java.awt.*;

public class ComputingTestGUI extends JFrame {
    private JButton exitButton;
    private ComputingTestModel computingTest;

    public ComputingTestGUI(ComputingTestModel computingTest) {
        this.computingTest = computingTest;
        this.setTitle("Computing Test");
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
        JLabel title = new JLabel("Computing Test: RSA Encryption Algorithm");
        title.setFont(new Font("Calibri", Font.BOLD, 20));
        title.setForeground(new Color(2, 95, 69, 255));
        title.setBounds(75, 20, 500, 30);
        panel.add(title);

        JLabel description = new JLabel("<html>&emsp;A random text of 10.000 characters is encrypted and decrypted " +
                "according to <br>Rivest–Shamir–Adleman Algorithm.<Br>&emsp;These " +
                "operations are repeated 10 times.</html>");
        description.setFont(new Font("Calibri", Font.PLAIN, 14));
        description.setForeground(new Color(2, 95, 69, 255));
        description.setBounds(10, 60, 500, 100);
        panel.add(description);

        JLabel execTimeLabel = new JLabel("Execution Time (in milliseconds):");
        execTimeLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        execTimeLabel.setForeground(new Color(2, 95, 69, 255));
        execTimeLabel.setBounds(10, 170, 500, 30);
        panel.add(execTimeLabel);

        JLabel execTime = new JLabel(Integer.toString(computingTest.getExecutionTime()));
        execTime.setFont(new Font("Calibri", Font.BOLD, 14));
        execTime.setForeground(new Color(2, 95, 69, 255));
        execTime.setBounds(220, 170, 400, 30);
        panel.add(execTime);

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
