import java.util.ArrayDeque;
import java.util.Queue;

public class a1161maxLevelSum {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        int max = Integer.MIN_VALUE;
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }

            if (sum > max) {
                max = sum;
                res = level;
            }

        }

        return res;
    }
}
