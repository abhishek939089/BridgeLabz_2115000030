import java.util.Scanner;

public class L1_Problem9 {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter rows: ");
      int rows = input.nextInt();
      System.out.print("Enter columns: ");
      int cols = input.nextInt();
      int[][] matrix = new int[rows][cols];
      int[] array = new int[rows * cols];
      int index = 0;
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            matrix[i][j] = input.nextInt();
            array[index++] = matrix[i][j];
         }
      }
      for (int i : array) System.out.print(i + " ");
   }
}
