import java.util.Scanner;

public class Problem15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the unit price of the item: ");
        double unitPrice = input.nextDouble();
        System.out.print("Enter the quantity to be bought: ");
        int quantity = input.nextInt();
        
        double totalPrice = unitPrice * quantity;
        System.out.println("The total purchase price is INR " + totalPrice + " if the quantity is " + quantity + " and the unit price is INR " + unitPrice);
    }
}
