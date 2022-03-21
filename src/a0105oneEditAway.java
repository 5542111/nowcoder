public class a0105oneEditAway {
    public static void main(String[] args) {
        System.out.println(new a0105oneEditAway().oneEditAway2("teacher", "bleacher"));
    }

    /**
     * 编辑距离的方式解决
     *
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        int n = first.length();
        int m = second.length();


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
                if (first.charAt(i - 1) != second.charAt(j - 1)) {
                    leftUp += 1;
                }
                dp[i][j] = Math.min(left, Math.min(up, leftUp));
            }
        }

        return dp[n][m] == 1 || dp[n][m] == 0;
    }

    public boolean oneEditAway2(String first, String second) {
        if (first.length() > second.length()) return oneEditAway2(second, first);
        if (second.length()- first.length() > 1) return false;
        if (first.length() == second.length()) {
            int count = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) count++;
            }
            return count <= 1;
        }
        int left = 0, offset = 0;
        while (left < first.length()) {
            if (first.charAt(left) != second.charAt(left+offset)) {
                offset++;
            }else{
                left++;
            }
            if (offset > 1) return false;
        }
        return true;
    }
}
