import java.util.Scanner;

public class L1_Problem7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the month: ");
        int month = sc.nextInt();
        System.out.print("Enter the day: ");
        int day = sc.nextInt();

        if ((month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
