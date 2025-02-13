import java.util.HashSet;

public class LongestConsecutive {
    public int findLongestSequence(int[] numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            uniqueNumbers.add(numbers[i]);
        }

        int maxLength = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (!uniqueNumbers.contains(numbers[i] - 1)) {
                int length = 1;
                while (uniqueNumbers.contains(numbers[i] + length)) {
                    length++;
                }
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestConsecutive sequenceFinder = new LongestConsecutive();
        int[] numbers = {100, 4, 200, 1, 3, 2};
        System.out.println(sequenceFinder.findLongestSequence(numbers));
    }
}
