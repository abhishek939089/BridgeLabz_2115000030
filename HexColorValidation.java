import java.util.regex.*;

public class HexColorValidation {
    public static void main(String[] args) {
        String regex = "^#[0-9A-Fa-f]{6}$";
        Pattern pattern = Pattern.compile(regex);

        String[] colors = {"#FFA500", "#ff4500", "#123", "#ABCDEF", "#GHIJKL"};

        for (String color : colors) {
            Matcher matcher = pattern.matcher(color);
            System.out.println(color + " is valid: " + matcher.matches());
        }
    }
}