import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

class JsonSerializer {
    public static String serialize(Object obj) throws IllegalAccessException, JsonProcessingException {
        Map<String, Object> jsonMap = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                jsonMap.put(annotation.name(), field.get(obj));
            }
        }
        return new ObjectMapper().writeValueAsString(jsonMap);
    }
}

public class CustomJsonSerialization {
    public static void main(String[] args) throws IllegalAccessException, JsonProcessingException {
        User user = new User("JohnDoe", 25);
        String jsonString = JsonSerializer.serialize(user);
        System.out.println(jsonString);
    }
}
