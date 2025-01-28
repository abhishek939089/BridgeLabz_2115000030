import java.util.Random;

public class L3_ZaraBonus {

    public static void main(String[] args) {
        int[][] employeeData = generateEmployeeData();
        int[][] updatedData = calculateBonusAndNewSalary(employeeData);
        displayResults(employeeData, updatedData);
    }

    public static int[][] generateEmployeeData() {
        Random rand = new Random();
        int[][] data = new int[10][2];
        for (int i = 0; i < 10; i++) {
            data[i][0] = rand.nextInt(90000) + 10000;
            data[i][1] = rand.nextInt(10);
        }
        return data;
    }

    public static int[][] calculateBonusAndNewSalary(int[][] data) {
        int[][] updatedData = new int[10][3];
        for (int i = 0; i < 10; i++) {
            int salary = data[i][0];
            int years = data[i][1];
            int bonus = 0;
            if (years > 5) {
                bonus = (int)(salary * 0.05);
            } else {
                bonus = (int)(salary * 0.02);
            }
            updatedData[i][0] = salary;
            updatedData[i][1] = bonus;
            updatedData[i][2] = salary + bonus;
        }
        return updatedData;
    }

    public static void displayResults(int[][] oldData, int[][] newData) {
        int oldSalarySum = 0, newSalarySum = 0, bonusSum = 0;
        System.out.println("Employee | Old Salary | Bonus | New Salary");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            oldSalarySum += oldData[i][0];
            bonusSum += newData[i][1];
            newSalarySum += newData[i][2];
            System.out.printf("%8d | %10d | %5d | %10d\n", i + 1, oldData[i][0], newData[i][1], newData[i][2]);
        }
        System.out.println("------------------------------------------------");
        System.out.printf("Total     | %10d | %5d | %10d\n", oldSalarySum, bonusSum, newSalarySum);
    }
}
