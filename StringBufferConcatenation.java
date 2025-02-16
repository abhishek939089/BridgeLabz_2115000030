import java.util.Scanner;

public class StringBufferConcatenation {
    public static String concatenateStrings(String[] strings) {
        StringBuffer result = new StringBuffer();
        for (String str : strings) {
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }

        System.out.println("Concatenated String: " + concatenateStrings(strings));
        scanner.close();
    }
}
