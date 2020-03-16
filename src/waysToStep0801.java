public class waysToStep0801 {
    public int waysToStep(int n) {
        final int mod = 1000000007;
        if (n <= 2) return n;
        if (n == 3) return 4;

        long[] dp = new long[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < n; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % mod;
        }

        return (int) dp[n - 1];

    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            System.out.println(dp[i]);
        }
        return dp[len];
    }


    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int start = 0;

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    int curLen = i - j + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = j;
                    }
                }

            }
        }
        return s.substring(start, start + maxLen);
    }

    public int uniquePaths(int m, int n) {
        if (n == 1 || m == 1) return 1;


        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[][] dp = new int[m][n];
        dp[0][0]=1;

        for (int i=1;i<m;i++)
        {
            if (obstacleGrid[i][0]==1) dp[i][0]=0;
            else dp[i][0]=dp[i-1][0];

        }
        for (int i=1;i<n;i++)
        {
            if (obstacleGrid[0][i]==1) dp[0][i]=0;
            else dp[0][i]=dp[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j]==1) dp[i][j]=0;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
