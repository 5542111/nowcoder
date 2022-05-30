import java.util.ArrayList;
import java.util.List;

public class a1022sumRootToLeaf {
    public int sumRootToLeaf(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(root, sb, res);
        return res.stream().reduce(Integer::sum).orElse(0);
    }

    private void dfs(TreeNode root, StringBuilder sb,  List<Integer> res) {
        if (root != null) {
            sb.append(root.val);
            if (root.left == null && root.right == null) {
                res.add(Integer.parseInt(sb.toString(),2));
                return;
            }
        } else return;

        if (root.left != null) {
            dfs(root.left, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (root.right != null) {
            dfs(root.right, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
