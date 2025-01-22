import java.util.Scanner;

public class L2_Problem11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the principal amount: ");
        double principal = input.nextDouble();
        System.out.print("Enter the rate of interest: ");
        double rate = input.nextDouble();
        System.out.print("Enter the time in years: ");
        double time = input.nextDouble();
        
        double simpleInterest = (principal * rate * time) / 100;
        System.out.println("The Simple Interest is " + simpleInterest + " for Principal " + principal + ", Rate of Interest " + rate + " and Time " + time);
    }
}
