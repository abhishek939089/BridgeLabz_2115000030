import java.util.Scanner;

public class L2_Problem1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int employeeCount = 10;
        double[] salaries = new double[employeeCount];
        double[] yearsOfService = new double[employeeCount];
        double[] bonuses = new double[employeeCount];
        double[] newSalaries = new double[employeeCount];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < employeeCount; i++) {
            while (true) {
                System.out.print("Enter salary for employee " + (i + 1) + ": ");
                double salary = input.nextDouble();
                System.out.print("Enter years of service for employee " + (i + 1) + ": ");
                double years = input.nextDouble();

                if (salary > 0 && years >= 0) {
                    salaries[i] = salary;
                    yearsOfService[i] = years;
                    break;
                } else {
                    System.out.println("Invalid input. Please enter again.");
                }
            }
        }
        for (int i = 0; i < employeeCount; i++) {
            double bonusPercentage = yearsOfService[i] > 5 ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusPercentage;
            newSalaries[i] = salaries[i] + bonuses[i];
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }
        System.out.println("Total bonus payout: " + totalBonus);
        System.out.println("Total old salary: " + totalOldSalary);
        System.out.println("Total new salary: " + totalNewSalary);
    }
}
