import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class CacheInterceptor {
    private static final Map<String, Object> cache = new HashMap<>();

    public static Object invokeCached(Object obj, String methodName, Object... args) throws Exception {
        Method method = obj.getClass().getMethod(methodName, int.class);
        if (method.isAnnotationPresent(CacheResult.class)) {
            String key = methodName + "_" + args[0];
            if (cache.containsKey(key)) {
                return cache.get(key);
            }
            Object result = method.invoke(obj, args);
            cache.put(key, result);
            return result;
        }
        return method.invoke(obj, args);
    }
}

class ExpensiveComputation {
    @CacheResult
    public int computeSquare(int num) {
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        return num * num;
    }
}

public class CustomCacheSystem {
    public static void main(String[] args) throws Exception {
        ExpensiveComputation computation = new ExpensiveComputation();

        long start = System.currentTimeMillis();
        System.out.println("First Call: " + CacheInterceptor.invokeCached(computation, "computeSquare", 5));
        System.out.println("Time Taken: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println("Second Call: " + CacheInterceptor.invokeCached(computation, "computeSquare", 5));
        System.out.println("Time Taken: " + (System.currentTimeMillis() - start) + "ms");
    }
}
