import java.util.*;

public class CountingSortStudentAges {
    public static void countingSort(int[] ages) {
        int minAge = 10, maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        for (int age : ages) count[age - minAge]++;

        for (int i = 1; i < range; i++) count[i] += count[i - 1];

        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] ages = new int[n];

        System.out.println("Enter ages (between 10 to 18): ");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
            if (ages[i] < 10 || ages[i] > 18) {
                System.out.println("Invalid age! Please enter ages between 10 and 18.");
                i--;
            }
        }

        countingSort(ages);
        System.out.println("Sorted Ages: " + Arrays.toString(ages));
    }
}
