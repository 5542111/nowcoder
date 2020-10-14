public class findTilt563 {
    private int tilt=0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return tilt;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        //类似后序遍历
        int left=dfs(root.left);
        int right=dfs(root.right);
        tilt+=Math.abs(left-right);
        return left+right+root.val;
    }
}
