import java.util.Scanner;

public class L2_FriendComparison {
    public static int findYoungest(int[] ages) {
        int youngest = ages[0];
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < youngest) youngest = ages[i];
        }
        return youngest;
    }

    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > tallest) tallest = heights[i];
        }
        return tallest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of friend " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter height of friend " + (i + 1) + ": ");
            heights[i] = scanner.nextInt();
        }

        System.out.println("Youngest Friend's Age: " + findYoungest(ages));
        System.out.println("Tallest Friend's Height: " + findTallest(heights));
    }
}
