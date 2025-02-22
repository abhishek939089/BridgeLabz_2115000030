import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {

    private static final String TEST_FILE = "testfile.txt";

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @Test
    void testWriteToFile() throws IOException {
        String content = "Hello, World!";
        FileProcessor.writeToFile(TEST_FILE, content);
        assertTrue(Files.exists(Paths.get(TEST_FILE)));
    }

    @Test
    void testReadFromFile() throws IOException {
        String content = "Hello, World!";
        FileProcessor.writeToFile(TEST_FILE, content);
        String readContent = FileProcessor.readFromFile(TEST_FILE);
        assertEquals(content, readContent);
    }

    @Test
    void testReadFromFile_FileNotFound() {
        assertThrows(IOException.class, () -> FileProcessor.readFromFile("nonexistent.txt"));
    }
}