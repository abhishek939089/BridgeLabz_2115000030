import java.util.Scanner;

public class L1_Problem9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the starting number for countdown: ");
        int counter = sc.nextInt();

        for (int i = counter; i > 0; i--) {
            System.out.println(i);
        }
        System.out.println("Liftoff!");
    }
}
