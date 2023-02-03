public class a1145btreeGameWinningMove {
    private int leftSize;
    private int rightSize;
    private int parentSize;

    private int x;


    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x = x;
        dfs(root);
        this.parentSize = n - 1 - leftSize - rightSize;
        return Math.max(Math.max(leftSize, rightSize), parentSize) * 2 > n;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.val == x) {
            leftSize = left;
            rightSize = right;
        }
        return left + right + 1;
    }
}
