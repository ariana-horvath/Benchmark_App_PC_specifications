package controller;

import model.PerformanceCountersModel;
import view.PerformanceCountersGUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerformanceCountersController {

    private PerformanceCountersGUI performanceCountersGUI;

    public PerformanceCountersController() throws IOException, InterruptedException {
        runProcess();
        performanceCountersGUI = new PerformanceCountersGUI(readFromFile());
        initializeListeners();
    }

    public void initializeListeners() {
        performanceCountersGUI.getExitButton().addActionListener(e->{
            performanceCountersGUI.setVisible(false);
        });
    }

    public void runProcess() throws IOException, InterruptedException {
        Process memoryTest = Runtime.getRuntime().exec("performanceCounters.exe");
        memoryTest.waitFor();
    }

    public PerformanceCountersModel readFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("performanceCountersOutput.txt"));
        scanner.useDelimiter(",");
        String nbProcessors = scanner.next();
        String pageSize = scanner.next();
        String processorType = scanner.next();
        String processorTypeStr = scanner.next();
        String processorArchitecture = scanner.next();
        String minAppAddr = scanner.next();
        String maxAppAddr = scanner.next();
        String memorySize = scanner.next();
        List<String> currentFreq = new ArrayList<>();
        List<String> maxFreq = new ArrayList<>();

        while(scanner.hasNext()) {
            currentFreq.add(scanner.next());
            maxFreq.add(scanner.next());
        }

        return new PerformanceCountersModel(nbProcessors, pageSize, processorType, processorTypeStr, processorArchitecture, minAppAddr, maxAppAddr, memorySize, currentFreq, maxFreq);
    }
}
