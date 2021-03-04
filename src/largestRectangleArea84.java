import java.util.Stack;

public class largestRectangleArea84 {
    public static void main(String[] args) {
        System.out.println(new largestRectangleArea84().largestRectangleArea(new int[]{1, 1}));
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];


        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < heights.length; i++) {
            System.out.println(left[i]+" "+ right[i]);
        }
        int ans=0;

        for (int i = 0; i < heights.length; i++) {
            ans=Math.max(ans,(right[i]-left[i]-1)*heights[i]);
        }


        return ans;
    }
}
