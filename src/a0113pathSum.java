import java.util.ArrayList;
import java.util.List;

public class a0113pathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSumHelper(root, new ArrayList<>(), res, targetSum);
        return res;
    }

    private void pathSumHelper(TreeNode root, List<Integer> path, List<List<Integer>> res, int target) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == target) {
            res.add(new ArrayList<>(path));
        }
        pathSumHelper(root.left, path, res, target - root.val);
        pathSumHelper(root.right, path, res, target - root.val);
        path.remove(path.size() - 1);
    }
}
