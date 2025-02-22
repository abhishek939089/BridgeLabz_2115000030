import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    @Test
    void testRegisterUser_Valid() {
        assertDoesNotThrow(() -> UserRegistration.registerUser("john_doe", "john@example.com", "Password123"));
    }

    @Test
    void testRegisterUser_InvalidUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("", "john@example.com", "Password123"));
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    void testRegisterUser_InvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("john_doe", "invalid-email", "Password123"));
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void testRegisterUser_InvalidPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("john_doe", "john@example.com", "weak"));
        assertEquals("Password must be at least 8 characters long, contain one uppercase letter, and one digit", exception.getMessage());
    }
}