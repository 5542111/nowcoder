public class a0064minPathSum {

    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row + 1][col + 1];

        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                if (i == 1) {
                    dp[i][j] = dp[i][j - 1] + grid[i - 1][j - 1];
                    continue;
                }
                if (j == 1) {
                    dp[i][j] = dp[i-1][j] + grid[i - 1][j - 1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][col];
    }
}
