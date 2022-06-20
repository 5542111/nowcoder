import java.util.ArrayList;
import java.util.List;

public class a0095generateTrees {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }

    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = dfs(start, i - 1);
            List<TreeNode> rightTrees = dfs(i+1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    res.add(cur);
                }
            }
        }

        return res;
    }

}
