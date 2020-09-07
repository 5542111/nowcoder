import java.util.ArrayList;
import java.util.List;

public class pathSum113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root==null)
        {
            return new ArrayList<>();
        }
        List<List<Integer>> res=new ArrayList<>();
        dfs(root,sum,new ArrayList<>(),res);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res) {
        if (root.val == sum && root.left == null && root.right == null) {
            temp.add(root.val);
            res.add(new ArrayList<>(temp));
            return;
        }
        if (root != null) {
            temp.add(root.val);
            if (root.left != null) {
                dfs(root.left, sum - root.val, temp, res);

            }
            if (root.right != null) {
                dfs(root.right, sum - root.val, temp, res);
            }
            temp.remove(temp.size()-1);
        }
    }
}
