import java.util.Scanner;

public class L2_Problem7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numberOfPersons = input.nextInt();

        double[][] personData = new double[numberOfPersons][3];
        String[] weightStatus = new String[numberOfPersons];

        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println("Person " + (i + 1) + ":");
            
            do {
                System.out.print("Height (in meters, positive value): ");
                personData[i][0] = input.nextDouble();
            } while (personData[i][0] <= 0);
            
            do {
                System.out.print("Weight (in kg, positive value): ");
                personData[i][1] = input.nextDouble();
            } while (personData[i][1] <= 0);
            
            personData[i][2] = personData[i][1] / (personData[i][0] * personData[i][0]);

            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nResults:");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height", "Weight", "BMI", "Status");
		System.out.println("------------------------------------------------");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n", 
                    personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}
