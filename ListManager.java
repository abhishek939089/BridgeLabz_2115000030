import java.util.List;
import java.util.ArrayList;

public class ListManager {
    public static void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public static boolean removeElement(List<Integer> list, int element) {
        return list.remove(Integer.valueOf(element));
    }

    public static int getSize(List<Integer> list) {
        return list.size();
    }
}