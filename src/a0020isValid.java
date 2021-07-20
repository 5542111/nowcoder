import java.util.Stack;

public class a0020isValid {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0 || s.length() == 0) return false;
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (!stack.isEmpty()) {
                char c = stack.peek();
                if ((c == '[' && chars[i] == ']') || (c == '{' && chars[i] == '}') || (c == '(' && chars[i] == ')')) {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            } else {
                stack.push(chars[i]);
            }


        }

        return stack.isEmpty();

    }
}
