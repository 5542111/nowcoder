import java.util.*;

public class a0198rob {
    Map<Integer, Integer> memo = new HashMap<>();

    public int rob(int[] nums) {
        return dfs(nums, nums.length - 1);
    }

    private int dfs(int[] nums, int n) {
        if (n < 0) return 0;
        int cache = memo.getOrDefault(n, -1);
        if (cache != -1) {
            return cache;
        }
        int res = Math.max(dfs(nums, n - 1), dfs(nums, n - 2) + nums[n]);
        memo.put(n, res);
        return res;
    }
    public int rob2(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
    public int rob3(int[] nums) {

        int dp0 = 0;
        int dp1 = nums[0];
        int res = dp1;
        for (int i = 2; i <= nums.length; i++) {
            res = Math.max(dp1,dp0+nums[i-1]);
            dp0 =dp1;
            dp1 = res;
        }
        return res;
    }


}
