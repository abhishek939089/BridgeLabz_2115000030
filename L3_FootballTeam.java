import java.util.Random;

public class L3_FootballTeam {
    public static void main(String[] args) {
        int[] heights = generateHeights();
        System.out.println("Shortest Height: " + findShortestHeight(heights));
        System.out.println("Tallest Height: " + findTallestHeight(heights));
        System.out.println("Mean Height: " + calculateMean(heights));
    }

    public static int[] generateHeights() {
        Random random = new Random();
        int[] heights = new int[11];
        for (int i = 0; i < 11; i++) {
            heights[i] = random.nextInt(101) + 150;
        }
        return heights;
    }

    public static int findShortestHeight(int[] heights) {
        int min = Integer.MAX_VALUE;
        for (int height : heights) {
            min = Math.min(min, height);
        }
        return min;
    }

    public static int findTallestHeight(int[] heights) {
        int max = Integer.MIN_VALUE;
        for (int height : heights) {
            max = Math.max(max, height);
        }
        return max;
    }

    public static double calculateMean(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum / 11.0;
    }
}
