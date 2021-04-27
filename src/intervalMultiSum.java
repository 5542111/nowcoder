import java.util.Stack;

public class intervalMultiSum {

    public static void main(String[] args) {
        int[] arr = {3, 1, 6, 4, 5, 2};
        System.out.println(solve(arr));
    }

    public static int solve(int[] arr) {
        int res = 0;
        int[] dist = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            dist[i] = dist[i - 1] + arr[i - 1];
        }

        for (int i = 0; i < arr.length + 1; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {

                System.out.print(stack + " ");
                int peak = arr[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();

                int right = i;

                System.out.print(stack + " ");
                int temp = dist[right] - dist[left + 1];

                res = Math.max(res, temp * peak);
                System.out.println(left + " " + i + " " + temp + " " + res);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int peak = arr[stack.pop()];
            int left = stack.isEmpty() ? -1 : stack.peek();

            int right = arr.length;


            int temp = dist[right] - dist[left + 1];
            System.out.println(left + 1 + " " + right + " " + temp + " " + res);
            res = Math.max(res, temp * peak);
        }
        return res;
    }
}
