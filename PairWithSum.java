import java.util.HashSet;

public class PairWithSum {
    public boolean hasPair(int[] numbers, int target) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (seenNumbers.contains(target - numbers[i])) {
                return true;
            }
            seenNumbers.add(numbers[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        PairWithSum pairSum = new PairWithSum();
        int[] numbers = {1, 4, 6, 8};
        System.out.println(pairSum.hasPair(numbers, 10));
    }
}
