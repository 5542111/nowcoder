import java.util.Stack;

public class maxProduct1339 {
    private long total = 0;
    private long max = 0;

    public int maxProduct(TreeNode root) {
        sum(root);
        helper(root, total);
        return (int) (max % 1000000007L);
    }

    public long helper(TreeNode root, long total) {
        if (root == null) {
            return 0;
        }
        long res = 0;
        if (root.left == null && root.right == null) {
            res = root.val;
        } else if (root.left == null) {
            res = root.val + helper(root.right, total);
        } else if (root.right == null) {
            res = root.val + helper(root.left, total);
        } else {
            res = root.val + helper(root.left, total) + helper(root.right, total);
        }
        if (res * (total - res) > max) {
            max = res * (total - res);
        }
        return res;
    }

    private void sum(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            total += temp.val;
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }
}
