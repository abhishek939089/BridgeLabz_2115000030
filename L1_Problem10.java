import java.util.Scanner;

public class L1_Problem10 {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a number: ");
      int number = input.nextInt();
      if (number <= 0) {
         System.out.println("Invalid number");
         System.exit(0);
      }
      String[] result = new String[number + 1];
      for (int i = 0; i <= number; i++) {
         if (i % 3 == 0 && i % 5 == 0) result[i] = "FizzBuzz";
         else if (i % 3 == 0) result[i] = "Fizz";
         else if (i % 5 == 0) result[i] = "Buzz";
         else result[i] = String.valueOf(i);
      }
      for (int i = 0; i < result.length; i++) {
         System.out.println("Position " + i + " = " + result[i]);
      }
   }
}
