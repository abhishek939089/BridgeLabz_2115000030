import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public <T> T getInstance(Class<T> clazz) throws Exception {
        if (instances.containsKey(clazz)) {
            return clazz.cast(instances.get(clazz));
        }

        T instance = createInstance(clazz);
        instances.put(clazz, instance);
        return instance;
    }

    private <T> T createInstance(Class<T> clazz) throws Exception {
        Constructor<T> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        T instance = constructor.newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Object dependency = getInstance(field.getType());
                field.setAccessible(true);
                field.set(instance, dependency);
            }
        }

        return instance;
    }
}

class Service {
    public void performService() {
        System.out.println("Service is running...");
    }
}

class Client {
    @Inject
    private Service service;

    public void execute() {
        service.performService();
    }
}

public class DependencyInjectionDemo {
    public static void main(String[] args) throws Exception {
        DIContainer container = new DIContainer();
        Client client = container.getInstance(Client.class);
        client.execute();
    }
}
