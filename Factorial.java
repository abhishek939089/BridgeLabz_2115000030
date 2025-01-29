import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        int factorial = calculateFactorial(num);
        System.out.println("Factorial: " + factorial);
    }

    public static int calculateFactorial(int num) {
        if (num == 0) return 1;
        return num * calculateFactorial(num - 1);
    }
}