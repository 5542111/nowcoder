import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if (root != null && root.left != null){
                    stack.push(root.left);
                    root=root.left;
            }else {
                root=stack.pop();
                res.add(root.val);
                if (root.right!=null) {
                    stack.push(root.right);
                }else {
                    root=null;
                }
            }
        }
        return res;
    }
}
