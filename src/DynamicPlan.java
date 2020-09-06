public class DynamicPlan {
    public int triangleTower(int[][] nums) {
        int max = 0;
        int[][] dp = new int[nums.length][nums.length];
        dp[0][0] = nums[0][0];

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + nums[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + nums[i][j];
                }
                max = Math.max(dp[i][j], max);
            }

        }

        return max;
    }

    public int editDistance(String str, String target) {
        int[][] dp = new int[str.length() + 1][target.length() + 1];
        for (int i = 0; i < str.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < target.length() + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < str.length() + 1; i++) {

            for (int j = 1; j < target.length() + 1; j++) {
                if (str.charAt(i - 1) == target.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[str.length()][target.length()];
    }


    public int zeroOnePack(int[] values, int[] weights, int V) {
        int n = weights.length;
        int[][] dp = new int[n + 1][V + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                dp[i][j] = j < weights[i] ? dp[i - 1][j] : Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
            }
        }
        return dp[n][V];
    }
}
