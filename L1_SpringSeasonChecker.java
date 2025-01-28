import java.util.Scanner;

public class L1_SpringSeasonChecker {
    public boolean isSpringSeason(int month, int day) {
        return (month == 3 && day >= 20) || (month == 6 && day <= 20) || (month > 3 && month < 6);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month: ");
        int month = scanner.nextInt();
        System.out.print("Enter day: ");
        int day = scanner.nextInt();

        L1_SpringSeasonChecker checker = new L1_SpringSeasonChecker();
        boolean isSpring = checker.isSpringSeason(month, day);

        if (isSpring) System.out.println("It's a Spring Season.");
        else System.out.println("Not a Spring Season.");
    }
}
