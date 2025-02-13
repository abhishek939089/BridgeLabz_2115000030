import java.util.HashMap;

public class TwoSum {
    public int[] findTwoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];

            if (indexMap.containsKey(complement)) {
                return new int[]{indexMap.get(complement), i};
            }

            indexMap.put(numbers[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();
        int[] numbers = {2, 7, 11, 15};
        int[] result = solver.findTwoSum(numbers, 9);
        System.out.println(result[0] + " " + result[1]);
    }
}
