public class a0112hasPathSum {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            return dfs(root,targetSum);
        }

        private boolean dfs(TreeNode root, int targetSum) {
            if (root == null) return false;

            if (targetSum == root.val && root.left == null && root.right == null) {
                return true;
            }

            return dfs(root.left, targetSum - root.val) || dfs(root.right, targetSum - root.val);
        }
}
