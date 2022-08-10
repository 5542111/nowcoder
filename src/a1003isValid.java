import java.util.Stack;

public class a1003isValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                stack.push(c);
            } else if (c == 'b') {
                if (stack.isEmpty()) return false;
                else {
                    stack.push(c);
                }
            } else {
                if (stack.size() < 2) return false;
                Character pop = stack.pop();
                Character pop1 = stack.pop();
                if (pop != 'b' || pop1 != 'a') return false;
            }
        }
        return stack.isEmpty();
    }
}
