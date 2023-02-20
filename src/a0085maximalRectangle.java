import java.util.*;

public class a0085maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int row = matrix.length, col = matrix[0].length;
        int[] heights = new int[col];
        int res = 0;
        for (char[] chars : matrix) {
            for (int j = 0; j < col; j++) {
                if (chars[j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            res = Math.max(res, largestRectangleArea(heights));
        }
        return res;
    }


    private int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.pop()] = i;
            }
            left[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(i);
        }
        int res = 0;

        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }

        return res;
    }
}
