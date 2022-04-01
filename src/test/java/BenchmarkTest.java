import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import controller.MultithreadTestController;
import controller.MemoryTestController;
import controller.ComputingTestController;

import java.io.IOException;

public class BenchmarkTest {

    @Test
    public void memoryTest() {
        try {
            MemoryTestController controller = new MemoryTestController();
            int execTime = controller.getMemoryTest().getExecutionTime();
            assertTrue(execTime >= 0 & execTime <= 20);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void computingTest() {
        try {
            ComputingTestController controller = new ComputingTestController();
            int execTime = controller.getComputingTest().getExecutionTime();
            assertTrue(execTime >= 1000 & execTime < 10000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void multithreadingTest() {
        try {
            MultithreadTestController controller = new MultithreadTestController();
            int execTime1 = controller.getMultithreadTest().getExecutionTime1();
            int execTime2 = controller.getMultithreadTest().getExecutionTime2();
            int execTime4 = controller.getMultithreadTest().getExecutionTime4();
            int execTime8 = controller.getMultithreadTest().getExecutionTime8();
            int execTime16 = controller.getMultithreadTest().getExecutionTime16();
            int execTime32 = controller.getMultithreadTest().getExecutionTime32();
            assertTrue(execTime1 >= 0 & execTime1 <= 10);
            assertTrue(execTime2 >= 0 & execTime2 <= 10);
            assertTrue(execTime4 >= 0 & execTime4 <= 10);
            assertTrue(execTime8 >= 0 & execTime8 <= 10);
            assertTrue(execTime16 >= 0 & execTime16 <= 10);
            assertTrue(execTime32 >= 0 & execTime32 <= 10);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
