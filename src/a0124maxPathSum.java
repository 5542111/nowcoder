public class a0124maxPathSum {
    private int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int tempMaxSum = root.val + Math.max(0, left) + Math.max(0, right);
        res = Math.max(res, tempMaxSum);
        return root.val + Math.max(0, Math.max(left, right));
    }

}
