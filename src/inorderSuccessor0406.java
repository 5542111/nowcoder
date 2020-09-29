import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderSuccessor0406 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        List<TreeNode> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if (root != null && root.left != null) {
                stack.push(root.left);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root);
                if (root.right != null) {
                    stack.push(root.right);
                    root=root.right;
                } else {
                    root = null;
                }
            }
        }
        int index = res.indexOf(p);

        if (index + 1 >= res.size()) {
            return null;
        }else {
            return res.get(index+1);
        }
    }
}
