import java.util.Arrays;

public class a494findTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;

        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }


    private int[] nums;
    private int[][] cache;

    /**
     * s = sum(nums)
     * p表示 为正数的数字的和
     * s-p 表示为负数的 原来的 和
     * p + (-(s-p)) ==target
     * p = (s+target)/2
     */
    public int findTargetSumWaysDFS(int[] nums, int target) {
        for (int x : nums) target += x;
        if (target < 0 || target % 2 == 1) return 0;
        target /= 2;

        this.nums = nums;
        int n = nums.length;
        cache = new int[n][target + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(cache[i], -1); // -1 表示没用访问过
        return dfs(n - 1, target);
    }

    private int dfs(int i, int c) {
        if (i < 0) return c == 0 ? 1 : 0;
        if (cache[i][c] != -1) return cache[i][c];
        if (c < nums[i]) return cache[i][c] = dfs(i - 1, c);
        return cache[i][c] = dfs(i - 1, c) + dfs(i - 1, c - nums[i]);
    }


    public int findTargetSumWays2(int[] nums, int target) {
        for (int x : nums) target += x;
        if (target < 0 || target % 2 == 1) return 0;
        target /= 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int c = 0; c < target + 1; c++) {
                if (c < nums[i]) dp[i + 1][c] = dp[i][c];
                dp[i + 1][c] = dp[i][c] + dp[i][c - nums[i]];
            }
        }
        return dp[n][target];
    }

    public int findTargetSumWays3(int[] nums, int target) {
        for (int x : nums) target += x;
        if (target < 0 || target % 2 == 1) return 0;
        target /= 2;
        int n = nums.length;
        int[][] dp = new int[2][target + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int c = 0; c < target + 1; c++) {
                if (c < nums[i]) dp[(i + 1)%2][c] = dp[i%2][c];
                dp[(i + 1)%2][c] = dp[i%2][c] + dp[i%2][c - nums[i]];
            }
        }
        return dp[n][target];
    }

    public int findTargetSumWaysUnified(int[] nums, int target) {
        for (int num : nums) {
            target += num;
        }
        if (target < 0 || (target & 1) == 1) {
            return 0;
        }
        target = target / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int c = target; c >= num; c--) {
                dp[c] += dp[c - num];
            }
        }
        return dp[target];
    }


}
