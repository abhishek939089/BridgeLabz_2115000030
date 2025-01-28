import java.util.Scanner;

public class L2_BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][3];
        String[] status = new String[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = scanner.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = scanner.nextDouble();
            data[i][2] = calculateBMI(data[i][0], data[i][1]);
            status[i] = determineStatus(data[i][2]);
        }

        for (int i = 0; i < 10; i++) {x
            System.out.println("Person " + (i + 1) + ": Height = " + data[i][1] + " cm, Weight = " + data[i][0] + " kg, BMI = " + data[i][2] + ", Status = " + status[i]);
        }
    }

    public static double calculateBMI(double weight, double height) {
        return weight / ((height / 100) * (height / 100));
    }

    public static String determineStatus(double bmi) {
        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}