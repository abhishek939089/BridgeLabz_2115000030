import java.util.regex.*;

public class ValidateCreditCard {
    public static void main(String[] args) {
        String visaRegex = "^4[0-9]{15}$";
        String masterCardRegex = "^5[0-9]{15}$";

        Pattern visaPattern = Pattern.compile(visaRegex);
        Pattern masterCardPattern = Pattern.compile(masterCardRegex);

        String[] cards = {"4111111111111111", "5500000000000004", "1234567890123456", "5105105105105100"};

        for (String card : cards) {
            Matcher visaMatcher = visaPattern.matcher(card);
            Matcher masterCardMatcher = masterCardPattern.matcher(card);

            if (visaMatcher.matches()) {
                System.out.println(card + " is a valid Visa card.");
            } else if (masterCardMatcher.matches()) {
                System.out.println(card + " is a valid MasterCard.");
            } else {
                System.out.println(card + " is not a valid Visa or MasterCard.");
            }
        }
    }
}