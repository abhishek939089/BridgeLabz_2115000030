import java.util.*;

public class RotateList {
    public static <T> void rotateList(List<T> list, int positions) {
        int n = list.size();
        positions = positions % n;
        List<T> temp = new ArrayList<>(list.subList(0, positions));
        for (int i = 0; i < n - positions; i++) {
            list.set(i, list.get(i + positions));
        }
        for (int i = 0; i < positions; i++) {
            list.set(n - positions + i, temp.get(i));
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        rotateList(numbers, 2);
        System.out.println(numbers);
    }
}
