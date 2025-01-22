import java.util.Scanner;

public class L2_Problem10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the total number of chocolates: ");
        int chocolates = input.nextInt();
        System.out.print("Enter the number of children: ");
        int children = input.nextInt();
        
        int chocolatesPerChild = chocolates / children;
        int remainingChocolates = chocolates % children;
        
        System.out.println("The number of chocolates each child gets is " + chocolatesPerChild + " and the number of remaining chocolates are " + remainingChocolates);
    }
}
