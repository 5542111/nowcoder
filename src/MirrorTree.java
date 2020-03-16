public class MirrorTree {
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        if (root != null) {
            SwitchChildren(root);
        }
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null)
        {
            Mirror(root.right);
        }
    }

    public void SwitchChildren(TreeNode root) {
        if (root.left != null && root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }


    }
}
