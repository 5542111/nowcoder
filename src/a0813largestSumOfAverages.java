public class a0813largestSumOfAverages {

    public double largestSumOfAverages(int[] nums, int k) {
        double[] prefix = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        double[][] dp = new double[nums.length + 1][k + 1];

        for (int i = 1; i <= nums.length; i++) {
            dp[i][1] = prefix[i] / i;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = i; j <= nums.length; j++) {
                for (int l = i - 1; l < j; l++) {
                    dp[j][i] = Math.max(dp[j][i], dp[l][i - 1] + (prefix[j] - prefix[l]) / (j - l));
                }
            }
        }
        return dp[nums.length][k];

    }
}
