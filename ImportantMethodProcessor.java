import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Application {
    @ImportantMethod(level = "HIGH")
    public void criticalTask() {
        System.out.println("Executing critical task...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void secondaryTask() {
        System.out.println("Executing secondary task...");
    }

    public void normalTask() {
        System.out.println("Executing normal task...");
    }
}

public class ImportantMethodProcessor {
    public static void main(String[] args) {
        Application app = new Application();
        Method[] methods = app.getClass().getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName() + ", Level: " + annotation.level());
            }
        }

        app.criticalTask();
        app.secondaryTask();
        app.normalTask();
    }
}
