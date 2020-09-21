public class isBalanced0404 {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        int left=treeDepth(root.left);
        int right=treeDepth(root.right);
        if(Math.abs(left-right)>1)
        {
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    private int treeDepth(TreeNode root) {
        if (root != null) {
            int left = treeDepth(root.left);
            int right = treeDepth(root.right);
            return left > right ? left + 1 : right + 1;
        }
        return 0;
    }
}
