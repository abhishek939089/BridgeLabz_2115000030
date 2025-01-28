import java.util.Scanner;

public class L1_QuotientAndRemainder {
    public int[] findRemainderAndQuotient(int number, int divisor) {
        return new int[] { number / divisor, number % divisor };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = scanner.nextInt();
        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();

        L1_QuotientAndRemainder calculator = new L1_QuotientAndRemainder();
        int[] result = calculator.findRemainderAndQuotient(number, divisor);

        System.out.println("Quotient: " + result[0]);
        System.out.println("Remainder: " + result[1]);
    }
}
