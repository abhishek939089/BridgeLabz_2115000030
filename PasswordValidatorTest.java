import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("StrongPass1"));
    }

    @Test
    void testInvalidPassword_NoUppercase() {
        assertFalse(PasswordValidator.isValid("weakpass1"));
    }

    @Test
    void testInvalidPassword_NoDigit() {
        assertFalse(PasswordValidator.isValid("WeakPass"));
    }

    @Test
    void testInvalidPassword_TooShort() {
        assertFalse(PasswordValidator.isValid("Pass1"));
    }

    @Test
    void testInvalidPassword_Empty() {
        assertFalse(PasswordValidator.isValid(""));
    }
}