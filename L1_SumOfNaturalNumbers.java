import java.util.Scanner;

public class L1_SumOfNaturalNumbers {
    public int sumOfNaturalNumbers(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        L1_SumOfNaturalNumbers calculator = new L1_SumOfNaturalNumbers();
        int sum = calculator.sumOfNaturalNumbers(n);

        System.out.println("The sum of first " + n + " natural numbers is: " + sum);
    }
}
