import java.util.Scanner;

public class L2_SumNaturalNumbers {
    public static int sumUsingRecursion(int n) {
        if (n == 0) return 0;
        return n + sumUsingRecursion(n - 1);
    }

    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive natural number.");
            return;
        }

        int sumRecursion = sumUsingRecursion(n);
        int sumFormula = sumUsingFormula(n);
        System.out.println("Sum using Recursion: " + sumRecursion);
        System.out.println("Sum using Formula: " + sumFormula);
        System.out.println("Results match: " + (sumRecursion == sumFormula));
    }
}
