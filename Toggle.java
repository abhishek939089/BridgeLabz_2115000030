import java.util.Scanner;

public class Toggle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        String toggled = toggleCase(str);
        System.out.println("Toggled String: " + toggled);
    }

    public static String toggleCase(String str) {
        String toggled = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                toggled += Character.toLowerCase(ch);
            } else {
                toggled += Character.toUpperCase(ch);
            }
        }
        return toggled;
    }
}