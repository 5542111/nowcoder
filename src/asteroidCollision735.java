import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class asteroidCollision735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (Integer i : asteroids) {
            flag:
            {
                while (!stack.isEmpty() && i < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -i) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -i) {
                        stack.pop();
                    }
                    break flag;
                }
                stack.push(i);
            }

        }
        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }
}
