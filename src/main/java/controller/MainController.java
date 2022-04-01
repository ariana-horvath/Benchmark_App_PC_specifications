package controller;

import view.MainGUI;

import java.io.IOException;

public class MainController {

    private MainGUI mainGUI;

    public MainController() {
        mainGUI = new MainGUI();
        initializeListeners();
    }

    public void initializeListeners() {
        mainGUI.getPerformanceCountersButton().addActionListener(e->{
            try {
                new PerformanceCountersController();
            } catch (IOException | InterruptedException exception) {
                exception.printStackTrace();
                mainGUI.displayErrorMessage(exception);
            }
        });

        mainGUI.getMemoryTestButton().addActionListener(e->{
            try {
                mainGUI.displayInformationMessage("Test Running...");
                new MemoryTestController();
            } catch (IOException | InterruptedException exception) {
                exception.printStackTrace();
                mainGUI.displayErrorMessage(exception);
            }
        });

        mainGUI.getComputingTestButton().addActionListener(e->{
            try {
                mainGUI.displayInformationMessage("Test Running...");
                new ComputingTestController();
            } catch (IOException | InterruptedException exception) {
                exception.printStackTrace();
                mainGUI.displayErrorMessage(exception);
            }
        });

        mainGUI.getMultithreadTestButton().addActionListener(e->{
            try {
                mainGUI.displayInformationMessage("Test Running...");
                new MultithreadTestController();
            } catch (IOException | InterruptedException exception) {
                exception.printStackTrace();
                mainGUI.displayErrorMessage(exception);
            }
        });

        mainGUI.getExitButton().addActionListener(e->{
            System.exit(0);
        });
    }
}
