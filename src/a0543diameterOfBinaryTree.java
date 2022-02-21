public class a0543diameterOfBinaryTree {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        treeDepth(root);
        return res;
    }

    private int treeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        res = Math.max(left + right, res);
        return Math.max(left, right) + 1;
    }
}
