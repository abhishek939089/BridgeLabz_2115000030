import java.util.Arrays;

public class L3_NumberChecker {
    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public static int[] getDigitsArray(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        return digits;
    }

    public static int sumOfDigits(int number) {
        int[] digits = getDigitsArray(number);
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int number) {
        int[] digits = getDigitsArray(number);
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number) {
        int sum = sumOfDigits(number);
        return number % sum == 0;
    }

    public static int[][] findDigitFrequencies(int number) {
        int[] digits = getDigitsArray(number);
        int[][] frequencyArray = new int[10][2];

        for (int i = 0; i < 10; i++) {
            frequencyArray[i][0] = i;
        }

        for (int digit : digits) {
            frequencyArray[digit][1]++;
        }

        return frequencyArray;
    }

    public static void main(String[] args) {
        int number = 1729;

        System.out.println("Number: " + number);
        System.out.println("Count of digits: " + countDigits(number));

        int[] digits = getDigitsArray(number);
        System.out.println("Digits array: " + Arrays.toString(digits));

        System.out.println("Sum of digits: " + sumOfDigits(number));
        System.out.println("Sum of squares of digits: " + sumOfSquaresOfDigits(number));

        System.out.println("Is Harshad number: " + isHarshadNumber(number));

        int[][] frequencyArray = findDigitFrequencies(number);
        System.out.println("Digit frequencies:");
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i][1] > 0) {
                System.out.println("Digit " + frequencyArray[i][0] + ": " + frequencyArray[i][1] + " times");
            }
        }
    }
}
