import java.lang.annotation.*;
import java.lang.reflect.Method;

enum Priority {
    LOW, MEDIUM, HIGH
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    Priority priority() default Priority.MEDIUM;
    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = Priority.HIGH, assignedTo = "Alice")
    public void completeTask() {
        System.out.println("Task is being completed...");
    }
}

public class AnnotationProcessor {
    public static void main(String[] args) throws Exception {
        TaskManager taskManager = new TaskManager();
        Method method = taskManager.getClass().getMethod("completeTask");

        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            System.out.println("Task Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }

        taskManager.completeTask();
    }
}
