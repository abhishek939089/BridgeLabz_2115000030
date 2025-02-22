import java.util.regex.*;

public class ValidateSSN {
    public static void main(String[] args) {
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        String[] ssns = {"123-45-6789", "123456789", "987-65-4321", "123-45-678"};

        for (String ssn : ssns) {
            Matcher matcher = pattern.matcher(ssn);
            System.out.println(ssn + " is valid: " + matcher.matches());
        }
    }
}