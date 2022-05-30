import java.util.List;

public class a2096getDirections {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode intervalNode = getLowestCommonAncestor(root, startValue, destValue);
        int src = findSrc(intervalNode, startValue);
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < src; i++) {
            res.append('U');
        }
        findDest(intervalNode,destValue,new StringBuilder(),res);
        return res.toString();
    }

    //找到最近公共祖先
    private TreeNode getLowestCommonAncestor(TreeNode root, int startValue, int destValue) {
        if (root == null || root.val == startValue || root.val == destValue) return root;
        TreeNode left = getLowestCommonAncestor(root.left, startValue, destValue);
        TreeNode right = getLowestCommonAncestor(root.right, startValue, destValue);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    //寻找公共祖先到dest的路径
    private void findDest(TreeNode root, int destValue, StringBuilder sb, StringBuilder res) {
        if (root.val == destValue) {
            res.append(sb.toString());
            return;
        }
        if (root.right != null) {
            sb.append('R');
            findDest(root.right, destValue, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (root.left != null) {
            sb.append('L');
            findDest(root.left, destValue, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    //寻找start到公共祖先有几个'U'
    private int findSrc(TreeNode root, int startValue) {
        if (root == null) return 10000;
        if (root.val == startValue) return 0;
        return Math.min(findSrc(root.left, startValue), findSrc(root.right, startValue)) + 1;
    }
}
