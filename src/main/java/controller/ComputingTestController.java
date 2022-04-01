package controller;

import model.ComputingTestModel;
import view.ComputingTestGUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ComputingTestController {

    private ComputingTestGUI computingTestGUI;
    private ComputingTestModel computingTest;

    public ComputingTestController() throws IOException, InterruptedException {
        runProcess();
        int execTime = readFromFile();
        computingTest = new ComputingTestModel(execTime);
        computingTestGUI = new ComputingTestGUI(computingTest);
        initializeListeners();
    }

    public void initializeListeners() {
        computingTestGUI.getExitButton().addActionListener(e->{
            computingTestGUI.setVisible(false);
        });
    }

    public void runProcess() throws IOException, InterruptedException {
        Process computingTest = Runtime.getRuntime().exec("computingTest.exe");
        computingTest.waitFor();
    }

    public int readFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("computingTest.txt"));
        int execTime = scanner.nextInt();
        return execTime;
    }

    public ComputingTestModel getComputingTest() {
        return computingTest;
    }
}
