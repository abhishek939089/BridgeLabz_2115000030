import java.lang.reflect.Field;

class User {
    private String name = "Alice";
    private int age = 25;

    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}

public class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            json.append("\"").append(fields[i].getName()).append("\": \"")
                .append(fields[i].get(obj)).append("\"");
            if (i < fields.length - 1) json.append(", ");
        }
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        User user = new User();
        System.out.println(toJson(user));
    }
}
