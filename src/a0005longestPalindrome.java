public class a0005longestPalindrome {
    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;

        int len = s.length();

        int[][] dp = new int[len][len];

        int max = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s.charAt(i) == s.charAt(len - j - 1)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }

                }
                if (dp[i][j] > max) {
                    int prev = len - 1 - j;
                    if (prev - 1 + dp[i][j] == i) {
                        max = dp[i][j];
                        end = i;
                    }

                }

            }


        }

        return s.substring(end - max + 1, end + 1);

    }
}
