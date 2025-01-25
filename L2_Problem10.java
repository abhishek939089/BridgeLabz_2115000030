import java.util.Scanner;

public class L2_Problem10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        String numStr = input.next();
        int number = Integer.parseInt(numStr);

        if (number < 0) {
            number = Math.abs(number);
        }

        int[] frequency = new int[10];
        
        for (char c : numStr.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = c - '0';
                frequency[digit]++;
            }
        }

        System.out.println("Digit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i]);
            }
        }
    }
}
