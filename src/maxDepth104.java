import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class maxDepth104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int len = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            len++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

        }
        return len;


    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth2(root.left);
            int rightHeight = maxDepth2(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;


    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;


        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.offer(new Pair<>(root, 1));

        int len = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> tmp = queue.poll();
            TreeNode temp = tmp.getKey();
            len = tmp.getValue();
            if (temp.left == null && temp.right == null) {
                break;
            }

            if (temp.left != null) {
                queue.offer(new Pair<>(temp.left, len + 1));
            }
            if (temp.right != null) {
                queue.offer(new Pair<>(temp.right, len + 1));
            }


        }
        return len;

    }
}
