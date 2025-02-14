import java.util.*;

public class MergeSortBookPrices {
    public static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);
            merge(prices, left, mid, right);
        }
    }

    private static void merge(int[] prices, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(prices, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(prices, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length)
            prices[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        while (i < leftArr.length) prices[k++] = leftArr[i++];
        while (j < rightArr.length) prices[k++] = rightArr[j++];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter book prices: ");
        for (int i = 0; i < n; i++) prices[i] = sc.nextInt();
        mergeSort(prices, 0, n - 1);
        System.out.println("Sorted Prices: " + Arrays.toString(prices));
    }
}
