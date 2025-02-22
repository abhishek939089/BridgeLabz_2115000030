import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    private DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }

    @Test
    void testConnection() {
        assertTrue(dbConnection.isConnected());
    }

    @Test
    void testDisconnection() {
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected());
    }
}