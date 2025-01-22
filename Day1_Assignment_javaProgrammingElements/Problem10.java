import java.util.Scanner;

public class Problem10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your height in cm: ");
        double heightInCm = input.nextDouble();

        double totalInches = heightInCm / 2.54;
        int feet = (int) (totalInches / 12);
        double remainingInches = totalInches % 12;

        System.out.println("Your Height in cm is " + heightInCm + ", in feet is " + feet + " and inches is " + remainingInches);
    }
}
