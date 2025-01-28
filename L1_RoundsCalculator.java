import java.util.Scanner;

public class L1_RoundsCalculator {
    public int calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        return (int) Math.ceil(5000 / perimeter);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter side1: ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter side2: ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter side3: ");
        double side3 = scanner.nextDouble();

        L1_RoundsCalculator calculator = new L1_RoundsCalculator();
        int rounds = calculator.calculateRounds(side1, side2, side3);

        System.out.println("Number of rounds to complete 5 km: " + rounds);
    }
}
