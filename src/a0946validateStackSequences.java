import java.util.Stack;

public class a0946validateStackSequences {
    public static void main(String[] args) {
        System.out.println(new a0946validateStackSequences().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        for (int i = 0; i < popped.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && popped[left] == stack.peek()) {
                stack.pop();
                left++;
            }
        }
        return stack.isEmpty();
    }
}
