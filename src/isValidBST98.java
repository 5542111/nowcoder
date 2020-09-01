import java.util.Stack;

public class isValidBST98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> res = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if (root != null && root.left != null) {
                stack.push(root.left);
                root = root.left;
            } else {
                root = stack.pop();
                if (!res.isEmpty() && res.peek() >= root.val) {
                    return false;
                }
                res.add(root.val);
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
