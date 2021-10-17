import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class a0230kthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if (root != null && root.left != null) {
                stack.push(root.left);
                root = root.left;
            } else {
                root = stack.pop();
                if (--k== 0) {
                    break;
                }
                if (root.right != null) {
                    stack.push(root.right);
                    root = root.right;
                } else {
                    root = null;
                }
            }
        }
        return root.val;
    }
}
