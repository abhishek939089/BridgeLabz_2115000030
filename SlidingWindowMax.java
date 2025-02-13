import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
    public void findMax(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                System.out.print(nums[deque.peek()] + " ");
            }
        }
    }

    public static void main(String[] args) {
        SlidingWindowMax slidingWindow = new SlidingWindowMax();
        int[] numbers = {1, 3, -1, -3, 5, 3, 6, 7};
        slidingWindow.findMax(numbers, 3);
    }
}
