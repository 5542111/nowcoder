import java.util.Arrays;

public class a0583minDistance {


    private int[][] memo;
    private char[] chars1;
    private char[] chars2;

    //本质就是最长公共子序列
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new int[m + 1][n + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        chars1 = word1.toCharArray();
        chars2 = word2.toCharArray();
        int commonLen = dfs(0, 0, m, n);

        return m + n - 2 * commonLen;
    }

    private int dfs(int i, int j, int m, int n) {
        if (i == m || j == n) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (chars1[i] == chars2[j]) {
            return memo[i][j] = 1 + dfs(i + 1, j + 1, m, n);
        }
        return memo[i][j] = Math.max(dfs(i + 1, j, m, n), dfs(i, j + 1, m, n));
    }
}
