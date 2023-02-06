import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class a0224calculate {
    public static void main(String[] args) {
        System.out.println(new a0224calculate().calculate2(" 3    /2 "));
    }

    //s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
    public int calculate(String s) {

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == ')') {
                int temp = 0;
                while (!stack.isEmpty()) {
                    String pop = stack.pop();
                    if (pop.equals("(")) break;
                    String pop1 = stack.pop();
                    if ("-".equals(pop1)) {
                        temp -= Integer.parseInt(pop);
                    } else {
                        temp += Integer.parseInt(pop);
                    }
                    if (pop1.equals("(")) break;
                }
                stack.push(String.valueOf(temp));
                i++;
            } else if (s.charAt(i) == '(' || s.charAt(i) == '+' || s.charAt(i) == '-') {
                stack.push(String.valueOf(s.charAt(i)));
                i++;
            } else {
                int left = i;
                int right = i;
                while (right < s.length() && Character.isDigit(s.charAt(right))) {
                    right++;
                }
                stack.push(s.substring(left, right));
                i = right;
            }
        }
        System.out.println(stack);
        long res = 0L;
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            if (stack.isEmpty()) {
                res += Long.parseLong(pop);
            } else {
                String pop1 = stack.pop();
                res += pop1.equals("-") ? -Long.parseLong(pop) : Long.parseLong(pop);
            }
        }
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) res;
    }
    //s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开

    public int calculate2(String s) {
        s = s.replaceAll(" ", "");
        Deque<Integer> queue = new ArrayDeque<>();
        char op = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) || i == s.length() - 1) {
                switch (op) {
                    case '+': {
                        queue.add(num);
                        break;
                    }
                    case '-': {
                        queue.add(-num);
                        break;
                    }
                    case '*': {
                        queue.add(queue.pollLast() * num);
                        break;
                    }
                    default: {
                        queue.add(queue.pollLast() / num);
                        break;
                    }
                }
                op = s.charAt(i);
                num = 0;
            }
        }
        System.out.println(queue);
        int ans = 0;
        while (!queue.isEmpty()) {
            ans += queue.pop();
        }
        return ans;

    }
}
