import java.util.Scanner;

public class CompareString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();
        String result = compareStrings(str1, str2);
        System.out.println(result);
    }

    public static String compareStrings(String str1, String str2) {
        int result = 0;
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                result = str1.charAt(i) - str2.charAt(i);
                break;
            }
        }
        if (result == 0 && str1.length() != str2.length()) {
            result = str1.length() - str2.length();
        }
        return result < 0 ? "\"" + str1 + "\" comes before \"" + str2 + "\"" : "\"" + str2 + "\" comes before \"" + str1 + "\"";
    }
}