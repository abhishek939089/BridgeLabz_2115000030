import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        System.out.print("Enter operation (+, -, *, /): ");
        char op = scanner.next().charAt(0);
        double result = 0;
        switch (op) {
            case '+': result = add(a, b); break;
            case '-': result = subtract(a, b); break;
            case '*': result = multiply(a, b); break;
            case '/': result = divide(a, b); break;
            default: System.out.println("Invalid operation"); return;
        }
        System.out.println("Result: " + result);
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }
}