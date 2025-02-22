import java.util.regex.*;

public class LicensePlateValidation {
    public static void main(String[] args) {
        String regex = "^[A-Z]{2}\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        String[] plates = {"AB1234", "A12345", "XY5678", "123XYZ", "ZZ9999"};

        for (String plate : plates) {
            Matcher matcher = pattern.matcher(plate);
            System.out.println(plate + " is valid: " + matcher.matches());
        }
    }
}