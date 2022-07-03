public class a0522findLUSlength {
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            //过滤重复
            if (strs[i].length() <= ans) continue;
            //标识位 表示自己是别人的子序列
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (check(strs[i], strs[j])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans = Math.max(ans, strs[i].length());
            }

        }
        return ans;
    }

    private boolean check(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        if (m < n) return false;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                dp[i][j] = Math.max(Math.max(dp[i][j], dp[i - 1][j]), dp[i][j - 1]);
                if (dp[i][j] == n) return true;
            }
        }

        return false;
    }
}