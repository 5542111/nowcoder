import java.util.Stack;

public class a0735asteroidCollision {
    public static void main(String[] args) {
        new a0735asteroidCollision().asteroidCollision(new int[]{10, 2, -5});
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            flag:
            {
                while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                    if (stack.peek() < -asteroid) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -asteroid) {
                        stack.pop();
                    }
                    break flag;
                }
                stack.push(asteroid);
            }
        }
        System.out.println(stack);


        int size = stack.size();
        if (size == 0) return new int[]{};
        int[] res = new int[size];
        while (!stack.isEmpty()) {
            res[--size] = stack.pop();
        }
        return res;
    }
}
