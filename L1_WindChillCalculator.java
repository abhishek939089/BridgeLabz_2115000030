import java.util.Scanner;

public class L1_WindChillCalculator {
    public double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter wind speed in mph: ");
        double windSpeed = scanner.nextDouble();

        L1_WindChillCalculator calculator = new L1_WindChillCalculator();
        double windChill = calculator.calculateWindChill(temperature, windSpeed);

        System.out.println("The wind chill temperature is: " + windChill);
    }
}
