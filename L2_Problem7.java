import java.util.Scanner;

public class L2_Problem7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your weight : ");
        double weight = sc.nextDouble();
        
        System.out.print("Enter your height : ");
        double heightInCm = sc.nextDouble();

        double heightInM = heightInCm / 100;

        double bmi = weight / (heightInM * heightInM);

        System.out.println("Your BMI is: " + bmi);

        if (bmi <= 18.4) {
            System.out.println("Status: Underweight");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Status: Normal");
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            System.out.println("Status: Overweight");
        } else {
            System.out.println("Status: Obese");
        }
    }
}
