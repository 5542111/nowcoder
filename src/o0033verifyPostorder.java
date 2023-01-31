import java.util.Stack;

public class o0033verifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorderHelper(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorderHelper(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int index = i;
        while (postorder[index] < postorder[j]) index++;
        int idx = index;
        while (postorder[index] > postorder[j]) index++;
        return index == j && verifyPostorderHelper(postorder, i, idx - 1) && verifyPostorderHelper(postorder, idx, j - 1);
    }

    public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }
}
