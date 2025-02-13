import java.util.Stack;

public class StockSpan {
    public void calculateSpan(int[] prices, int size) {
        Stack<Integer> indexStack = new Stack<>();
        int[] span = new int[size];
        indexStack.push(0);
        span[0] = 1;

        for (int i = 1; i < size; i++) {
            while (!indexStack.isEmpty() && prices[indexStack.peek()] <= prices[i]) {
                indexStack.pop();
            }
            if (indexStack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - indexStack.peek();
            }
            indexStack.push(i);
        }

        for (int i = 0; i < size; i++) {
            System.out.print(span[i] + " ");
        }
    }

    public static void main(String[] args) {
        StockSpan stockSpan = new StockSpan();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        stockSpan.calculateSpan(prices, prices.length);
    }
}
