import java.util.ArrayDeque;
import java.util.Queue;

public class a1302deepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            res =0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                res += poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }

        }

        return res;

    }
}
