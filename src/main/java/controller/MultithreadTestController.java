package controller;

import model.MultithreadTestModel;
import view.MultithreadTestGUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MultithreadTestController {

    private MultithreadTestGUI multithreadTestGUI;
    private MultithreadTestModel multithreadTest;

    public MultithreadTestController() throws IOException, InterruptedException {
        runProcess(1);
        int execTime1 = readFromFile();
        System.out.println(execTime1);
        runProcess(2);
        int execTime2 = readFromFile();
        System.out.println(execTime2);
        runProcess(4);
        int execTime4 = readFromFile();
        System.out.println(execTime4);
        runProcess(8);
        int execTime8 = readFromFile();
        System.out.println(execTime8);
        runProcess(16);
        int execTime16 = readFromFile();
        System.out.println(execTime16);
        runProcess(32);
        int execTime32 = readFromFile();
        System.out.println(execTime32);
        multithreadTest = new MultithreadTestModel(execTime1, execTime2, execTime4, execTime8, execTime16, execTime32);
        multithreadTestGUI = new MultithreadTestGUI(multithreadTest);
        initializeListeners();
    }

    public void initializeListeners() {
        multithreadTestGUI.getExitButton().addActionListener(e->{
            multithreadTestGUI.setVisible(false);
        });
    }

    public void runProcess(int nbThreads) throws IOException, InterruptedException {
        Process computingTest = Runtime.getRuntime().exec("multithreadVowelsTest.exe" + " " + Integer.toString(nbThreads));
        computingTest.waitFor();
    }

    public int readFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("multithreadTest.txt"));
        int execTime = scanner.nextInt();
        return execTime;
    }

    public MultithreadTestModel getMultithreadTest() {
        return multithreadTest;
    }
}
