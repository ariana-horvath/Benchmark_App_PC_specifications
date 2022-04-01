package view;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {
    private JButton performanceCountersButton;
    private JButton memoryTestButton;
    private JButton computingTestButton;
    private JButton multithreadTestButton;
    private JButton exitButton;

    /**
     * Instantiates a new Main screen.
     */
    public MainGUI() {
        this.setTitle("Benchmark Application");
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

    private void initializeForm(JPanel panel) {
        JLabel titleLabel = new JLabel("BENCHMARK APPLICATION");
        titleLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        titleLabel.setForeground(new Color(2, 95, 69, 255));
        titleLabel.setBounds(135, 40, 400, 30);
        panel.add(titleLabel);

        JLabel titleLabel2 = new JLabel("FOR PC PERFORMANCE PARAMETERS");
        titleLabel2.setFont(new Font("Calibri", Font.PLAIN, 14));
        titleLabel2.setForeground(new Color(2, 95, 69, 255));
        titleLabel2.setBounds(135, 65, 400, 30);
        panel.add(titleLabel2);

        performanceCountersButton = new JButton("Performance Counters");
        performanceCountersButton.setBounds(140, 120, 210, 30);
        performanceCountersButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        performanceCountersButton.setForeground(new Color(2, 95, 69, 255));
        panel.add(performanceCountersButton);

        memoryTestButton = new JButton("Memory Speed Test");
        memoryTestButton.setBounds(140, 180, 210, 30);
        memoryTestButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        memoryTestButton.setForeground(new Color(2, 95, 69, 255));
        panel.add(memoryTestButton);

        computingTestButton = new JButton("Computing Test");
        computingTestButton.setBounds(140, 240, 210, 30);
        computingTestButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        computingTestButton.setForeground(new Color(2, 95, 69, 255));
        panel.add(computingTestButton);

        multithreadTestButton = new JButton("Multithreading Test");
        multithreadTestButton.setBounds(140, 300, 210, 30);
        multithreadTestButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        multithreadTestButton.setForeground(new Color(2, 95, 69, 255));
        panel.add(multithreadTestButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(140, 400, 210, 30);
        exitButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        exitButton.setForeground(new Color(2, 95, 69, 255));
        panel.add(exitButton);
    }

    public void displayErrorMessage(Exception exception) {
        if (exception != null) {
            String message = exception.getMessage();
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", new Color(140, 246, 187));
            UI.put("Panel.background", new Color(140, 246, 187));
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void displayInformationMessage(String message) {
        if (!message.isEmpty()) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", new Color(140, 246, 187));
            UI.put("Panel.background", new Color(140, 246, 187));
            JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public JButton getPerformanceCountersButton() {
        return performanceCountersButton;
    }

    public JButton getMemoryTestButton() {
        return memoryTestButton;
    }

    public JButton getComputingTestButton() {
        return computingTestButton;
    }

    public JButton getMultithreadTestButton() {
        return multithreadTestButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
