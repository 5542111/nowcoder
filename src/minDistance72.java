public class minDistance72 {
    public static void main(String[] args) {
        new minDistance72().minDistance("horse","ros");
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        //存在空串情况
        if (m * n == 0) return m + n;

        int[][] dp = new int[n + 1][m + 1];

        //处理边界数据
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = i;
        }


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int leftUp = dp[i - 1][j - 1];
                int left = dp[i][j - 1] + 1;
                int up = dp[i - 1][j] + 1;

                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftUp += 1;
                }

                dp[i][j] = Math.min(left, Math.min(up, leftUp));

            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.print(dp[i][j]+" ");

            }
            System.out.println();
        }

        return dp[n][m];


    }
}
