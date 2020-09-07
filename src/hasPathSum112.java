public class hasPathSum112 {
    public boolean hasPathSum(TreeNode root, int sum) {

        return dfs(root, sum);
    }

    public boolean dfs(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (sum == root.val && root.left == null && root.right == null) {
            return true;
        }

        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
    }
}
