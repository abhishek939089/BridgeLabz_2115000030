import java.util.*;

public class InsertionSortEmployeeIDs {
    public static void insertionSort(int[] ids) {
        int n = ids.length;
        for (int i = 1; i < n; i++) {
            int key = ids[i], j = i - 1;
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        int[] ids = new int[n];
        System.out.println("Enter Employee IDs: ");
        for (int i = 0; i < n; i++) ids[i] = sc.nextInt();
        insertionSort(ids);
        System.out.println("Sorted Employee IDs: " + Arrays.toString(ids));
    }
}
