import java.lang.reflect.Method;

class MethodTimer {
    public static void measureExecutionTime(Object obj, String methodName, Object... args) throws Exception {
        Method method = null;
        for (Method m : obj.getClass().getDeclaredMethods()) {
            if (m.getName().equals(methodName) && m.getParameterCount() == args.length) {
                method = m;
                break;
            }
        }

        if (method == null) {
            throw new NoSuchMethodException("Method not found: " + methodName);
        }

        method.setAccessible(true);
        long startTime = System.nanoTime();
        method.invoke(obj, args);
        long endTime = System.nanoTime();
        System.out.println("Execution time of " + methodName + ": " + (endTime - startTime) + " ns");
    }
}

class SampleOperations {
    public void fastMethod() {
        System.out.println("Fast method executed.");
    }

    public void slowMethod() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Slow method executed.");
    }
}

public class MethodExecutionTiming {
    public static void main(String[] args) throws Exception {
        SampleOperations obj = new SampleOperations();
        MethodTimer.measureExecutionTime(obj, "fastMethod");
        MethodTimer.measureExecutionTime(obj, "slowMethod");
    }
}
