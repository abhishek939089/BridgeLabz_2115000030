import java.util.Scanner;
import java.util.Random;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int low = 1, high = 100;
        System.out.println("Think of a number between 1 and 100.");
        while (true) {
            int guess = generateGuess(low, high, random);
            System.out.println("Is your number " + guess + "? (high/low/correct)");
            String feedback = scanner.nextLine();
            if (feedback.equals("correct")) {
                System.out.println("I guessed it!");
                break;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            }
        }
    }

    public static int generateGuess(int low, int high, Random random) {
        return random.nextInt(high - low + 1) + low;
    }
}