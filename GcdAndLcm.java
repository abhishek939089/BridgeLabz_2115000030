import java.util.Scanner;

public class GcdAndLcm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int gcd = calculateGCD(a, b);
        int lcm = calculateLCM(a, b, gcd);
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
    }

    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}