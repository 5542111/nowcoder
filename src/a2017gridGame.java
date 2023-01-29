public class a2017gridGame {
    public long gridGame(int[][] grid) {
        int len = grid[0].length;
        long[][] dp = new long[2][len + 1];
        for (int i = 1; i <= len; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i - 1];
            dp[1][i] = dp[1][i - 1] + grid[1][i - 1];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            ans = Math.min(ans, Math.max(dp[0][len]- dp[0][i],dp[1][i-1]));
        }
        return ans;
    }
}
