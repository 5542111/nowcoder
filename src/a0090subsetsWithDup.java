import java.util.*;

public class a0090subsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new LinkedList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> queue, int k) {
        if (k == nums.length) {
            res.add(new ArrayList<>(queue));
            return;
        }

        //选择第k个元素
        queue.addLast(nums[k]);
        dfs(nums, res, queue, k + 1);
        queue.pollLast();

        //不选择第k个元素
        int i = k;
        while (i < nums.length && nums[i] == nums[k]) {
            i++;
        }
        dfs(nums, res, queue, i);
    }
}
