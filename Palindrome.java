import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        boolean isPalindrome = checkPalindrome(str);
        System.out.println(isPalindrome ? "Palindrome" : "Not Palindrome");
    }

    public static boolean checkPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}