import org.junit.jupiter.api.*;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {

    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        ListManager.addElement(list, 10);
        assertTrue(list.contains(10));
        assertEquals(1, ListManager.getSize(list));
    }

    @Test
    void testRemoveElement() {
        ListManager.addElement(list, 20);
        ListManager.addElement(list, 30);
        assertTrue(ListManager.removeElement(list, 20));
        assertFalse(list.contains(20));
        assertEquals(1, ListManager.getSize(list));
    }

    @Test
    void testGetSize() {
        ListManager.addElement(list, 40);
        ListManager.addElement(list, 50);
        assertEquals(2, ListManager.getSize(list));
    }
}