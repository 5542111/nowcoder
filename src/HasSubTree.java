public class HasSubTree {
    public static void main(String[] args) {

    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root2 == null || root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            if (tree1HasTree2(root1, root2)) {
                return true;
            }
        }
        //分别从左子树和右子树判断
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

    }

    public boolean tree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true; //子树已经遍历完 全在母树中
        if (root1 == null) return false; //母树遍历完 而子树还在遍历
        return root1.val == root2.val && tree1HasTree2(root1.left, root2.left) && tree1HasTree2(root1.right, root2.right); //递归遍历左右节点
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    public TreeNode() {

    }

}