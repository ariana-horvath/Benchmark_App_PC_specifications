package model;

public class MultithreadTestModel {
    private int executionTime1;
    private int executionTime2;
    private int executionTime4;
    private int executionTime8;
    private int executionTime16;
    private int executionTime32;

    public MultithreadTestModel(int executionTime1, int executionTime2, int executionTime4, int executionTime8,
                                int executionTime16, int executionTime32) {
        this.executionTime1 = executionTime1;
        this.executionTime2 = executionTime2;
        this.executionTime4 = executionTime4;
        this.executionTime8 = executionTime8;
        this.executionTime16 = executionTime16;
        this.executionTime32 = executionTime32;
    }

    public int getExecutionTime1() {
        return executionTime1;
    }

    public int getExecutionTime2() {
        return executionTime2;
    }

    public int getExecutionTime4() {
        return executionTime4;
    }

    public int getExecutionTime8() {
        return executionTime8;
    }

    public int getExecutionTime16() {
        return executionTime16;
    }

    public int getExecutionTime32() {
        return executionTime32;
    }
}
