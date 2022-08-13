import java.util.Stack;

public class a0768maxChunksToSorted {
    public static void main(String[] args) {
        System.out.println(new a0768maxChunksToSorted().maxChunksToSorted(new int[]{4, 2, 2, 1, 1}));
    }

    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            if (stack.isEmpty() || i >= stack.peek()) {
                stack.push(i);
            } else {
                Integer pop = stack.pop();
                while (!stack.isEmpty() && stack.peek() > i) {
                    stack.pop();
                }
                stack.push(pop);
            }
            System.out.println(stack);
        }

        return stack.size();
    }
}
