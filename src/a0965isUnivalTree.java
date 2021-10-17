import java.util.Stack;

public class a0965isUnivalTree {
    public boolean isUnivalTree(TreeNode root) {
        boolean left = root.left == null || (root.val == root.left.val && isUnivalTree(root.left));
        boolean right = root.right == null || (root.val == root.right.val && isUnivalTree(root.right));
        return left && right;
    }

    public boolean isUnivalTree1(TreeNode root) {
        if (root == null) return true;
        int first = root.val;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if (root != null && root.left != null) {
                stack.push(root.left);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val != first) {
                    return false;
                }
                if (root.right != null) {
                    stack.push(root.right);
                    root = root.right;
                } else {
                    root = null;
                }
            }
        }
        return true;
    }

}
