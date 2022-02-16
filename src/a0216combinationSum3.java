import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class a0216combinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new LinkedList<>(), 0, k, n);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> queue, int index, int k, int n) {

        if (n < 0) {
            return;
        } else if (n == 0) {
            if (queue.size() == k) {
                res.add(new ArrayList<>(queue));
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {
            queue.addLast(nums[i]);
            dfs(nums, res, queue, i + 1, k, n - nums[i]);
            queue.pollLast();
        }
    }
}
