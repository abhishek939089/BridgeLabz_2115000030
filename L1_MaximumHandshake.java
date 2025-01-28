import java.util.Scanner;

public class L1_MaximumHandshake {
    public int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        L1_MaximumHandshake handshakeCalculator = new L1_MaximumHandshake();
        int handshakes = handshakeCalculator.calculateHandshakes(numberOfStudents);

        System.out.println("The maximum number of handshakes among " + numberOfStudents + " students is: " + handshakes);
    }
}
