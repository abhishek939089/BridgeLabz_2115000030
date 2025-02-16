import java.util.Arrays;
import java.util.Scanner;

public class LinearBinarySearchChallenge {
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] present = new boolean[n + 1];
        for (int num : arr) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }
        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int missing = findFirstMissingPositive(arr);
        System.out.println("First missing positive number: " + missing);

        Arrays.sort(arr);
        System.out.print("Enter target number for binary search: ");
        int target = scanner.nextInt();
        int index = binarySearch(arr, target);
        System.out.println(index != -1 ? "Target found at index: " + index : "Target not found");
        scanner.close();
    }
}
