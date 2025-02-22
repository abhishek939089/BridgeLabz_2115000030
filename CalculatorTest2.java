import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest2 {

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> Calculator.divide(10, 0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Test
    void testDivideValid() {
        assertEquals(2, Calculator.divide(10, 5));
    }
}