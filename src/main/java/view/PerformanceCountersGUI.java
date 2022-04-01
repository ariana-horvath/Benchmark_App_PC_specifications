package view;

import model.PerformanceCountersModel;

import javax.swing.*;
import java.awt.*;

public class PerformanceCountersGUI extends JFrame {
    private JButton exitButton;
    private PerformanceCountersModel performanceCounters;

    public PerformanceCountersGUI(PerformanceCountersModel performanceCountersModel) {
        this.performanceCounters = performanceCountersModel;
        this.setTitle("PC Performance Parameters");
        this.setSize(500, 600);
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
        JLabel title = new JLabel("PC Performance Parameters");
        title.setFont(new Font("Calibri", Font.BOLD, 20));
        title.setForeground(new Color(2, 95, 69, 255));
        title.setBounds(120, 20, 500, 30);
        panel.add(title);

        JLabel nbProcLabel = new JLabel("Number of processors:");
        nbProcLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        nbProcLabel.setForeground(new Color(2, 95, 69, 255));
        nbProcLabel.setBounds(10, 70, 500, 30);
        panel.add(nbProcLabel);

        JLabel nbProc = new JLabel(performanceCounters.getNbProcessors());
        nbProc.setFont(new Font("Calibri", Font.PLAIN, 14));
        nbProc.setForeground(new Color(2, 95, 69, 255));
        nbProc.setBounds(220, 70, 500, 30);
        panel.add(nbProc);

        JLabel procTypeLabel = new JLabel("Processor type:");
        procTypeLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        procTypeLabel.setForeground(new Color(2, 95, 69, 255));
        procTypeLabel.setBounds(10, 100, 500, 30);
        panel.add(procTypeLabel);

        JLabel procType = new JLabel(performanceCounters.getProcessorType());
        procType.setFont(new Font("Calibri", Font.PLAIN, 14));
        procType.setForeground(new Color(2, 95, 69, 255));
        procType.setBounds(220, 100, 500, 30);
        panel.add(procType);

        JLabel procTypeStr = new JLabel(performanceCounters.getProcessorTypeStr());
        procTypeStr.setFont(new Font("Calibri", Font.PLAIN, 14));
        procTypeStr.setForeground(new Color(2, 95, 69, 255));
        procTypeStr.setBounds(220, 120, 500, 30);
        panel.add(procTypeStr);

        JLabel procArchitectureLabel = new JLabel("Processor architecture:");
        procArchitectureLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        procArchitectureLabel.setForeground(new Color(2, 95, 69, 255));
        procArchitectureLabel.setBounds(10, 150, 500, 30);
        panel.add(procArchitectureLabel);

        JLabel procArchitecture = new JLabel(performanceCounters.getProcessorArchitecture());
        procArchitecture.setFont(new Font("Calibri", Font.PLAIN, 14));
        procArchitecture.setForeground(new Color(2, 95, 69, 255));
        procArchitecture.setBounds(220, 150, 500, 30);
        panel.add(procArchitecture);

        JLabel pageSizeLabel = new JLabel("Page size:");
        pageSizeLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        pageSizeLabel.setForeground(new Color(2, 95, 69, 255));
        pageSizeLabel.setBounds(10, 180, 500, 30);
        panel.add(pageSizeLabel);

        JLabel pageSize = new JLabel(performanceCounters.getPageSize() + " Bytes");
        pageSize.setFont(new Font("Calibri", Font.PLAIN, 14));
        pageSize.setForeground(new Color(2, 95, 69, 255));
        pageSize.setBounds(220, 180, 500, 30);
        panel.add(pageSize);

        JLabel minAppAddrLabel = new JLabel("Minimum application address:");
        minAppAddrLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        minAppAddrLabel.setForeground(new Color(2, 95, 69, 255));
        minAppAddrLabel.setBounds(10, 210, 500, 30);
        panel.add(minAppAddrLabel);

        JLabel minAppAddr = new JLabel("0x" + performanceCounters.getMinAppAddr());
        minAppAddr.setFont(new Font("Calibri", Font.PLAIN, 14));
        minAppAddr.setForeground(new Color(2, 95, 69, 255));
        minAppAddr.setBounds(220, 210, 500, 30);
        panel.add(minAppAddr);

        JLabel maxAppAddrLabel = new JLabel("Maximum application address:");
        maxAppAddrLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        maxAppAddrLabel.setForeground(new Color(2, 95, 69, 255));
        maxAppAddrLabel.setBounds(10, 240, 500, 30);
        panel.add(maxAppAddrLabel);

        JLabel maxAppAddr = new JLabel("0x" + performanceCounters.getMaxAppAddr());
        maxAppAddr.setFont(new Font("Calibri", Font.PLAIN, 14));
        maxAppAddr.setForeground(new Color(2, 95, 69, 255));
        maxAppAddr.setBounds(220, 240, 500, 30);
        panel.add(maxAppAddr);

        JLabel memSizeLabel = new JLabel("RAM memory size:");
        memSizeLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        memSizeLabel.setForeground(new Color(2, 95, 69, 255));
        memSizeLabel.setBounds(10, 270, 500, 30);
        panel.add(memSizeLabel);

        JLabel memSize = new JLabel(performanceCounters.getRamMemorySize() + " KB");
        memSize.setFont(new Font("Calibri", Font.PLAIN, 14));
        memSize.setForeground(new Color(2, 95, 69, 255));
        memSize.setBounds(220, 270, 500, 30);
        panel.add(memSize);

        JLabel processorLabel = new JLabel("Processor                         Current Frequency                         Maximum Frequency");
        processorLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        processorLabel.setForeground(new Color(2, 95, 69, 255));
        processorLabel.setBounds(10, 320, 500, 30);
        panel.add(processorLabel);

        JLabel processors = new JLabel("<html>#0<br>#1<br>#2<br>#3<br>#4<br>#5<br>#6<br>#7</html>");
        processors.setFont(new Font("Calibri", Font.PLAIN, 14));
        processors.setForeground(new Color(2, 95, 69, 255));
        processors.setBounds(30, 320, 20, 200);
        panel.add(processors);

        StringBuilder currentFreqStr = new StringBuilder(new String("<html>"));
        for(String str : performanceCounters.getCurrentFrequencies())
            currentFreqStr.append(str + " MHz").append("<br>");
        currentFreqStr.append("</html>");

        JLabel currentFreq = new JLabel(String.valueOf(currentFreqStr));
        currentFreq.setFont(new Font("Calibri", Font.PLAIN, 14));
        currentFreq.setForeground(new Color(2, 95, 69, 255));
        currentFreq.setBounds(175, 320, 70, 200);
        panel.add(currentFreq);

        StringBuilder maxFreqStr = new StringBuilder(new String("<html>"));
        for(String str : performanceCounters.getMaxFrequencies())
            maxFreqStr.append(str + " MHz").append("<br>");
        maxFreqStr.append("</html>");

        JLabel maxFreq = new JLabel(String.valueOf(maxFreqStr));
        maxFreq.setFont(new Font("Calibri", Font.PLAIN, 14));
        maxFreq.setForeground(new Color(2, 95, 69, 255));
        maxFreq.setBounds(370, 320, 70, 200);
        panel.add(maxFreq);

        exitButton = new JButton("Exit");
        exitButton.setBounds(140, 510, 210, 30);
        exitButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        exitButton.setForeground(new Color(2, 95, 69, 255));
        panel.add(exitButton);
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
