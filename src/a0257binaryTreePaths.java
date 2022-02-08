import java.util.ArrayList;
import java.util.List;

public class a0257binaryTreePaths {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        binaryTreePathsHelper(root, "", res);
        return res;
    }

    //深度
    private void binaryTreePathsHelper(TreeNode root, String temp, List<String> res) {
        if (root == null) return;
        StringBuilder sb = new StringBuilder(temp);
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            binaryTreePathsHelper(root.left, sb.toString(), res);
            binaryTreePathsHelper(root.right, sb.toString(), res);
        }
    }
}
