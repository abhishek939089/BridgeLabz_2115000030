import java.util.Scanner;

public class L1_Problem8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the starting number for countdown: ");
        int counter = sc.nextInt();

        while (counter > 0) {
            System.out.println(counter);
            counter--;
        }
        System.out.println("Liftoff!");
    }
}
