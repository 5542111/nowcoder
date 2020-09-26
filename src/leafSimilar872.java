import java.util.ArrayList;
import java.util.List;

public class leafSimilar872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res=new ArrayList<>();
        List<Integer> res1=new ArrayList<>();
        dfs(root1,res);
        dfs(root2,res1);
        return res.equals(res1);
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        if (root != null) {
            if (root.left != null) {
                dfs(root.left, res);
            }
            if (root.right != null) {
                dfs(root.right, res);
            }
        }

    }

}
