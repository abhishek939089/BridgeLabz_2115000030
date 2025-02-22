import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    @Timeout(2)
    void testLongRunningTask() throws InterruptedException {
        String result = TaskManager.longRunningTask();
        assertEquals("Task completed", result);
    }
}