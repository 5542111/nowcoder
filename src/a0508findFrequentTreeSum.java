import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a0508findFrequentTreeSum {
    private Map<Integer, Integer> map;
    private int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        postOrder(root);
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private int postOrder(TreeNode root) {
        if (root == null)
            return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);
        int val = root.val + left + right;
        int count = map.getOrDefault(val, 0) + 1;
        max = Math.max(max, count);
        map.put(val, count);
        return val;
    }
}
