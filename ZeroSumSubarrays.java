import java.util.HashMap;

public class ZeroSumSubarrays {
    public void countZeroSum(int[] numbers) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0, count = 0;
        prefixSumMap.put(0, 1);

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (prefixSumMap.containsKey(sum)) {
                count += prefixSumMap.get(sum);
            }
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        ZeroSumSubarrays zeroSum = new ZeroSumSubarrays();
        int[] numbers = {4, 2, -3, -1, 0, 4};
        zeroSum.countZeroSum(numbers);
    }
}
