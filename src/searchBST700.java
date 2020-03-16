import java.util.Stack;

public class searchBST700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        stack.push(p);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.val == val) {
                return temp;
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }


        }

        return null;

    }

    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null || val == root.val) return root;

        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }




}
