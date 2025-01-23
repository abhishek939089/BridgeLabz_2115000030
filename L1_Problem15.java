import java.util.Scanner;

public class L1_Problem15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();

        if (n >= 0) {
            long factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            System.out.println("Factorial: " + factorial);
        } else {
            System.out.println("Invalid input. Enter a non-negative integer.");
        }
    }
}
