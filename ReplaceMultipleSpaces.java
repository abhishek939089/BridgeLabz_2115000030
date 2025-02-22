import java.util.regex.*;

public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        String text = "This    is  an     example   with  multiple spaces.";
        String replacedText = text.replaceAll("\\s+", " ");

        System.out.println(replacedText);
    }
}