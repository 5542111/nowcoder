import java.util.ArrayList;
import java.util.List;

public class a0982countTriplets {

    private List<List<Integer>> ans;
    private List<Integer> list;
    //暴力
    public int countTriplets(int[] nums) {
        ans = new ArrayList<>();
        list = new ArrayList<>();
        dfs(nums, 0);
        System.out.println(ans);
        return ans.size();
    }

    private void dfs(int[] nums, int index) {
        if (list.size() == 3) {
            if ((list.get(0) & list.get(1) & list.get(2)) == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i);
            list.remove(list.size() - 1);
        }
    }


    /**
     * @author [https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/solutions/2145654/you-ji-qiao-de-mei-ju-chang-shu-you-hua-daxit/]
     *
     * // hash 优化
     */

    public int countTriplets2(int[] nums) {
        int[] cnt = new int[1 << 16];
        for (int x : nums)
            for (int y : nums)
                ++cnt[x & y];
        int ans = 0;
        for (int x : nums)
            for (int y = 0; y < 1 << 16; ++y)
                if ((x & y) == 0)
                    ans += cnt[y];
        return ans;
    }
}
