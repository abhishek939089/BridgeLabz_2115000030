public class TaskManager {
    public static String longRunningTask() throws InterruptedException {
        Thread.sleep(3000);
        return "Task completed";
    }
}