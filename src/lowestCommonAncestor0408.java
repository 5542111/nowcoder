public class lowestCommonAncestor0408 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) {
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if (left!=null&&right!=null)
        {
            return root;
        }
        /**
         *  由于节点 p,q 一定在二叉树中，left和right不会同时为null
         *  若 left != null && right == null，说明在左子树中找到 p 或 q，而在右子树找不到 p 或 q，则剩下一个也在左子树
         *  所以 left 就是最近公共祖先
         *  另一种情况同理
         */



        return left!=null?left:right;



    }
}
