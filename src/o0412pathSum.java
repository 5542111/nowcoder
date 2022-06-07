import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class o0412pathSum {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        List<List<Integer>> res = new ArrayList<>();
        pathSumHelper(root, new ArrayList<>(), res, sum);
        return res.size() + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private void pathSumHelper(TreeNode root, List<Integer> path, List<List<Integer>> res, int target) {
        if (root == null) return;
        path.add(root.val);
        if (root.val == target) {
            res.add(new ArrayList<>(path));
        }
        pathSumHelper(root.left, path, res, target - root.val);
        pathSumHelper(root.right, path, res, target - root.val);
        path.remove(path.size() - 1);
    }

    HashMap<Integer, Integer> map;
    int res = 0;

    public int pathSum2(TreeNode root, int sum) {
        map = new HashMap<>();
        map.put(0, 1);
        int cur = 0;
        dfs(root, cur, sum);
        return res;
    }

    private void dfs(TreeNode root, int cur, int sum) {
        if (root == null) {
            return;
        }
        cur += root.val;
        res += map.getOrDefault(cur - sum, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        dfs(root.left, cur, sum);
        dfs(root.right, cur, sum);
        map.put(cur, map.getOrDefault(cur, 0) - 1);
    }


}
