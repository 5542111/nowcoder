public class a0072minDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int up = dp[i - 1][j] + 1;
                int upLeft = dp[i - 1][j - 1];
                int left = dp[i][j - 1] + 1;
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    upLeft += 1;
                }
                dp[i][j] = Math.min(up, Math.min(upLeft, left));

            }
        }

        return dp[m][n];
    }
}
