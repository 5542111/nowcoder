import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class o0054kthLargest {

    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if (root != null && root.left != null) {
                stack.push(root.left);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                    root = root.right;
                } else {
                    root = null;
                }
            }
        }
        return res.get(res.size() - k);
    }
}
