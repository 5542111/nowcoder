
import java.util.Stack;

public class a0054convertBST {
    int sum =0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
    public TreeNode convertBST2(TreeNode root){
        if (root==null) return null;
        int s=0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            if (root != null && root.right != null) {

                stack.push(root.right);
                root = root.right;
            } else {
                root = stack.pop();
                s+=root.val;
                root.val=s;
                if (root.left != null) {
                    stack.push(root.left);
                    root = root.left;
                } else {
                    root = null;
                }
            }
        }
        return node;
    }

}
