import java.util.Stack;

public class a1475finalPrices {

    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return prices;
    }

    public int[] finalPrices2(int[] prices) {

        int[] res = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int pop = stack.pop();
                res[pop] = prices[pop] - prices[i];
            }
            stack.push(i);
            res[i] = prices[i];
        }
        return res;
    }

}
