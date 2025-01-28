import java.util.Scanner;

public class L1_DistributeChocolates {
    public int[] distribute(int numberOfChocolates, int numberOfChildren) {
        return new int[] { numberOfChocolates / numberOfChildren, numberOfChocolates % numberOfChildren };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();
        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();

        L1_DistributeChocolates distributor = new L1_DistributeChocolates();
        int[] result = distributor.distribute(numberOfChocolates, numberOfChildren);

        System.out.println("Each child gets " + result[0] + " chocolates.");
        System.out.println("Remaining chocolates: " + result[1]);
    }
}
