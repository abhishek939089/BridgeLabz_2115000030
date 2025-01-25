import java.util.Scanner;

public class L2_Problem6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numberOfPersons = input.nextInt();

        double[] height = new double[numberOfPersons];
        double[] weight = new double[numberOfPersons];
        double[] bmi = new double[numberOfPersons];
        String[] status = new String[numberOfPersons];

        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println("Enter details for person " + (i + 1) + ": ");
            System.out.print("Height (in meters): ");
            height[i] = input.nextDouble();
            System.out.print("Weight (in kg): ");
            weight[i] = input.nextDouble();

            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi[i] <= 24.9) {
                status[i] = "Normal";
            } else if (bmi[i] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height", "Weight", "BMI", "Status");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n", height[i], weight[i], bmi[i], status[i]);
        }
    }
}
