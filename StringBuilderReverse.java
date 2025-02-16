import java.util.Scanner;

public class StringBuilderReverse {
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.println("Reversed string: " + reverseString(input));
        scanner.close();
    }
}
