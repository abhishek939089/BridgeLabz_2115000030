import java.util.Scanner;

public class L2_LeapYear {
    public static boolean isLeapYear(int year) {
        return (year >= 1582) && (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        if (isLeapYear(year)) {
            System.out.println("The year " + year + " is a Leap Year.");
        } else {
            System.out.println("The year " + year + " is not a Leap Year.");
        }
    }
}
