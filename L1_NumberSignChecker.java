import java.util.Scanner;

public class L1_NumberSignChecker {
    public int checkNumberSign(int number) {
        if (number > 0) return 1;
        else if (number < 0) return -1;
        else return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        L1_NumberSignChecker checker = new L1_NumberSignChecker();
        int result = checker.checkNumberSign(number);

        if (result == 1) System.out.println("The number is positive.");
        else if (result == -1) System.out.println("The number is negative.");
        else System.out.println("The number is zero.");
    }
}
