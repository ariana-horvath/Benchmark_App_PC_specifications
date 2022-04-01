package controller;

import model.MemoryTestModel;
import view.MemoryTestGUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MemoryTestController {

    private MemoryTestGUI memoryTestGUI;
    private MemoryTestModel memoryTest;

    public MemoryTestController() throws IOException, InterruptedException {
        runProcess();
        int execTime = readFromFile();
        memoryTest = new MemoryTestModel(execTime);
        memoryTestGUI = new MemoryTestGUI(memoryTest);
        initializeListeners();;
    }

    public void initializeListeners() {
        memoryTestGUI.getExitButton().addActionListener(e->{
            memoryTestGUI.setVisible(false);
        });
    }

    public void runProcess() throws IOException, InterruptedException {
        Process memoryTest = Runtime.getRuntime().exec("memoryTest.exe");
        memoryTest.waitFor();
    }

    public int readFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("memoryTest.txt"));
        int execTime = scanner.nextInt();
        return execTime;
    }

    public MemoryTestModel getMemoryTest() {
        return memoryTest;
    }
}
