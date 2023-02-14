import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class a1124longestWPI {
    public static void main(String[] args) {
        new a1124longestWPI().longestWPI2(new int[]{9, 9, 6, 0, 6, 6, 9});
    }


    /**
     * 暴力解决 o(n^2)复杂度
     *
     * @param hours
     * @return
     */
    public int longestWPI(int[] hours) {

        int left = 0;
        int right = 0;

        int ans = 0;
        while (left < hours.length) {
            int countTired = 0;
            int countUntired = 0;
            while (right < hours.length) {
                if (hours[right] <= 8) {
                    countUntired++;
                } else {
                    countTired++;
                }
                if (countTired > countUntired) {
                    ans = Math.max(ans, right - left + 1);
                }
                right++;
            }
            left++;
            right = left;
        }
        return ans;

    }

    /**
     * 前缀和 与 单调栈
     *
     * @param hours
     * @return
     */
    public int longestWPI2(int[] hours) {

        int[] preSum = new int[hours.length + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 0; i < hours.length; i++) {
            preSum[i + 1] = preSum[i] + (hours[i] > 8 ? 1 : -1);
            if (preSum[stack.peek()] > preSum[i + 1]) {
                stack.push(i + 1);
            }
        }
        System.out.println(stack);
        int ans = 0;
        for (int i = hours.length; i >= 1; i--) {
            while (!stack.isEmpty() && preSum[stack.peek()] < preSum[i]) {
                ans = Math.max(ans, i - stack.pop());
            }
        }
        return ans;

    }

    public int longestWPI23(int[] hours) {

        Map<Integer, Integer> preMap = new HashMap<>();

        int sum = 0;
        int ans = 0;

        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0) {
                ans = Math.max(ans, i + 1);
            } else {
                if (preMap.containsKey(sum - 1)) {
                    ans = Math.max(ans, i - preMap.get(sum - 1));
                }
            }
            if (!preMap.containsKey(sum)) {
                preMap.put(sum, i);
            }
        }
        return ans;
    }
}
