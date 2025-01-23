import java.util.Scanner;

public class L1_Problem3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number1: ");
		int number1 = input.nextInt();
		System.out.println("Enter the number2: ");
		int number2 = input.nextInt();
		System.out.println("Enter the number3: ");
		int number3 = input.nextInt();

        System.out.println("Is the first number the largest? " + (number1 > number2 && number1 > number3));
        System.out.println("Is the second number the largest? " + (number2 > number1 && number2 > number3));
        System.out.println("Is the third number the largest? " + (number3 > number1 && number3 > number2));
    }
}
