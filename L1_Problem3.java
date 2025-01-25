import java.util.Scanner;

public class L1_Problem3 {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a number: ");
      int number = input.nextInt();
      int[] table = new int[10];
      for (int i = 0; i < table.length; i++) {
         table[i] = number * (i + 1);
         System.out.println(number + " * " + (i + 1) + " = " + table[i]);
      }
   }
}
