import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class a114flatten {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        TreeNode head = res.poll();
        while (!res.isEmpty()) {
            head.left = null;
            head.right = res.poll();
            head = head.right;
        }
    }
}
