import java.util.Stack;

public class a1111maxDepthAfterSplit {
    public int[] maxDepthAfterSplit(String seq) {
        char[] splits = seq.toCharArray();
        int[] ans = new int[splits.length];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < splits.length; i++) {
            if (splits[i] == '(') {
                stack.push('(');
                ans[i] = stack.size() % 2;
            } else {
                ans[i] = stack.size() % 2;
                stack.pop();
            }
        }
        return ans;
    }
}
