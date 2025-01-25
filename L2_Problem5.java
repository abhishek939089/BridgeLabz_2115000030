import java.util.Scanner;

public class L2_Problem5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        int digitCount = 0;
        int temp = number;

        while (temp != 0) {
            temp /= 10;
            digitCount++;
        }

        int[] digits = new int[digitCount];
        int index = 0;
        while (number != 0) {
            digits[index++] = number % 10;
            number /= 10;
        }

        System.out.print("Reversed number: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(digits[i]);
        }
    }
}
