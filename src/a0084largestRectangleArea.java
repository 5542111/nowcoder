import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class a0084largestRectangleArea {
    /**
     * 暴力
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int res = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int min = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                min = Math.min(heights[j], min);
                res = Math.max(res, (j - i + 1) * min);
            }
        }

        return res;
    }

    /**
     * 单调栈 + 哨兵
     *
     * 总体 就是利用单调栈 记录了每个下标 左边最远 与 右边最远
     * @param heights
     * @return
     */

    public int largestRectangleArea2(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) {
                right[stack.pollLast()] = i;
            }
            left[i] = !stack.isEmpty() ? stack.peekLast() : -1;
            stack.offerLast(i);
        }
        int res = 0;

        for (int i = 0; i < heights.length; i++) {
            System.out.println(i+ " "+right[i] + " " + left[i]);
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }

        return res;
    }
}
