import java.util.Scanner;

public class L1_Problem6 {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      double[] heights = new double[11];
      double sum = 0;
      for (int i = 0; i < heights.length; i++) {
         System.out.print("Enter height of player " + (i + 1) + ": ");
         heights[i] = input.nextDouble();
         sum += heights[i];
      }
      System.out.println("Mean height: " + (sum / 11));
   }
}
