import java.util.Scanner;

public class L2_Problem8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        int[][] marks = new int[numberOfStudents][3];
        double[] percentages = new double[numberOfStudents];
        String[] grades = new String[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                do {
                    System.out.print(subject + " marks (0-100): ");
                    marks[i][j] = input.nextInt();
                } while (marks[i][j] < 0 || marks[i][j] > 100);
            }

            int totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = totalMarks / 3.0;

            if (percentages[i] >= 80) {
                grades[i] = "A";
            } else if (percentages[i] >= 70) {
                grades[i] = "B";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
            } else if (percentages[i] >= 50) {
                grades[i] = "D";
            } else if (percentages[i] >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }

        System.out.println("\nResults:");
        System.out.printf("%-10s %-10s %-10s %-10s %-15s %-10s\n", "Physics", "Chemistry", "Maths", "Percentage", "Grade", "Remarks");
        for (int i = 0; i < numberOfStudents; i++) {
            String remarks = switch (grades[i]) {
                case "A" -> "Above agency-normalized standards";
                case "B" -> "At agency-normalized standards";
                case "C" -> "Below, but approaching standards";
                case "D" -> "Well below standards";
                case "E" -> "Too below standards";
                default -> "Remedial standards";
            };
            System.out.printf("%-10d %-10d %-10d %-10.2f %-15s %-10s\n", 
                marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i], remarks);
        }
    }
}
