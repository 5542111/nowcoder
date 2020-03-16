public class insertIntoBST701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) return new TreeNode(val);

        if (root.val < val) root.right = insertIntoBST(root.right, val);
        if (root.val > val) root.left = insertIntoBST(root.left, val);
        return root;
    }

    public TreeNode insertIntoBST1(TreeNode root, int val) {
        TreeNode temp = root;

        while (temp != null) {
            if (val > temp.val) {
                if (temp.right == null) {
                    temp.right = new TreeNode(val);
                    return root;
                } else {
                    temp = temp.right;
                }
            } else {
                if (temp.left == null) {
                    temp.left = new TreeNode(val);
                    return root;
                } else {
                    temp = temp.left;
                }
            }
        }
        return new TreeNode(val);
    }
}
