import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void performAdminTask() {
        System.out.println("Admin task executed.");
    }
}

public class RoleBasedAccessControl {
    public static void main(String[] args) throws Exception {
        User adminUser = new User("ADMIN");
        User normalUser = new User("USER");

        SecureService service = new SecureService();

        executeIfAuthorized(service, "performAdminTask", adminUser);
        executeIfAuthorized(service, "performAdminTask", normalUser);
    }

    public static void executeIfAuthorized(Object obj, String methodName, User user) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            String requiredRole = method.getAnnotation(RoleAllowed.class).value();
            if (user.getRole().equals(requiredRole)) {
                method.invoke(obj);
            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}
