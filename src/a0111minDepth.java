
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class a0111minDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int len = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            len = pair.getValue();
            TreeNode temp = pair.getKey();
            if (temp.left == null && temp.right == null) {
                break;
            }
            if (temp.left != null) {
                queue.add(new Pair<>(temp.left, len + 1));
            }
            if (temp.right != null) {
                queue.add(new Pair<>(temp.right, len + 1));
            }
        }
        return len;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null) return minDepth2(root.right) + 1;
        else if (root.right == null) return minDepth2(root.left) + 1;
        else return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
    }

    public int minDepth3(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth3(root.left);
        int right = minDepth3(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
