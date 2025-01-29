import java.util.Scanner;

public class MaximumOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int max = findMax(a, b, c);
        System.out.println("Maximum: " + max);
    }

    public static int findMax(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}