import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        double temp = scanner.nextDouble();
        System.out.print("Convert to (F/C): ");
        String unit = scanner.next();
        if (unit.equalsIgnoreCase("F")) {
            System.out.println("Celsius: " + fahrenheitToCelsius(temp));
        } else if (unit.equalsIgnoreCase("C")) {
            System.out.println("Fahrenheit: " + celsiusToFahrenheit(temp));
        }
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
}