import java.util.Scanner;

public class L1_MaximumHandshakes {
    public int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();

        L1_MaximumHandshakes handshakes = new L1_MaximumHandshakes();
        int maxHandshakes = handshakes.calculateHandshakes(numberOfStudents);

        System.out.println("Maximum number of handshakes: " + maxHandshakes);
    }
}
