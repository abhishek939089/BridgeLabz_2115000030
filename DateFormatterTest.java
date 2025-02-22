import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {

    @Test
    void testFormatDate_Valid() {
        assertEquals("25-12-2023", DateFormatter.formatDate("2023-12-25"));
        assertEquals("01-01-2020", DateFormatter.formatDate("2020-01-01"));
    }

    @Test
    void testFormatDate_InvalidFormat() {
        Exception exception = assertThrows(DateTimeParseException.class, () -> DateFormatter.formatDate("25-12-2023"));
        assertNotNull(exception);
    }

    @Test
    void testFormatDate_InvalidDate() {
        Exception exception = assertThrows(DateTimeParseException.class, () -> DateFormatter.formatDate("2023-02-30"));
        assertNotNull(exception);
    }
}