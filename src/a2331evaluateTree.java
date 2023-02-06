public class a2331evaluateTree {
    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }


    private boolean dfs(TreeNode root) {
        if (root.left == null) {
            return root.val == 1;
        }
        if (root.val == 2) {
            return dfs(root.left) || dfs(root.right);
        }
        return dfs(root.left) && dfs(root.right);

    }
}
