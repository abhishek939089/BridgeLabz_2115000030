import java.util.Scanner;

public class L3_Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int sum = 0, originalNumber = number;
        while (originalNumber != 0) {
            sum += originalNumber % 10;
            originalNumber /= 10;
        }
        if (number % sum == 0) {
            System.out.println(number + " is a Harshad Number");
        } else {
            System.out.println(number + " is not a Harshad Number");
        }
    }
}
