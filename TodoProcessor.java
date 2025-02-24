import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
    public void authenticateUser() {
        System.out.println("Authentication logic pending...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Database optimization pending...");
    }

    public void completedFeature() {
        System.out.println("This feature is completed.");
    }
}

public class TodoProcessor {
    public static void main(String[] args) {
        Project project = new Project();
        Method[] methods = project.getClass().getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Task: " + annotation.task() + ", Assigned To: " + annotation.assignedTo() + ", Priority: " + annotation.priority());
            }
        }

        project.authenticateUser();
        project.optimizeDatabase();
        project.completedFeature();
    }
}
