public class longestCommonSubsequence1143 {
    public static void main(String[] args) {
        new longestCommonSubsequence1143().longestCommonSubsequence("1ab2345cd", "12345ef");
    }

    /**
     * 最长子序列长度 不要求连续
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];


        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }
        for (int i = 0; i < text1.length() + 1; i++) {
            for (int j = 0; j < text2.length() + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[text1.length()][text2.length()];
    }

    /**
     * 最长连续子串
     * @param str1
     * @param str2
     * @return
     */
    public String longestCommonSubstring(String str1, String str2) {
        // write code here
        //动态规划

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int end = 0;
        int maxLen = 0;
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    end = j;
                }
            }
        }


        if (maxLen == 0) return "";

        return str2.substring(end - maxLen, end);

    }
}
