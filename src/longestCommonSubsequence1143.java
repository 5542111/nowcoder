import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class longestCommonSubsequence1143 {
    public static void main(String[] args) {
        new longestCommonSubsequence1143().longestCommonSubsequence2("abcde", "ace");
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

        int[][] grid = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }
        Set<String> hs = new TreeSet<>();
        traceBack(dp, text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length(), "", hs);
        System.out.println(hs);
        for (int i = 0; i < text1.length() + 1; i++) {
            for (int j = 0; j < text2.length() + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[text1.length()][text2.length()];
    }

    private int[][] cache;
    private char[] sChar;
    private char[] tChar;
    private int m;
    private int n;

    // 超时
    public int longestCommonSubsequence2(String s, String t) {
        m = s.length();
        n = t.length();
        sChar = s.toCharArray();
        tChar = t.toCharArray();
        cache = new int[m + 1][n + 1];
        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i == m || j == n) {
            return 0;
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        if (sChar[i] == tChar[j]) {
            return cache[i][j] = 1 + dfs(i + 1, j + 1);
        }
        return cache[i][j] = Math.max(dfs(i + 1, j), dfs(i, j + 1));

    }

    //转dp
    public int longestCommonSubsequence3(String s, String t) {
        int m = s.length();
        int n = t.length();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (sChar[i] == tChar[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }

    public int longestCommonSubsequence4(String s, String t) {
        int m = s.length();
        int n = t.length();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        int[][] dp = new int[2][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (sChar[i] == tChar[j]) {
                    dp[(i + 1) % 2][j + 1] = dp[i % 2][j] + 1;
                } else {
                    dp[(i + 1) % 2][j + 1] = Math.max(dp[(i + 1) % 2][j], dp[i % 2][j + 1]);
                }
            }
        }
        return dp[1][n];
    }


    public int longestCommonSubsequence5(String s, String t) {
        int m = s.length();
        int n = t.length();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        int[] dp = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int pre = dp[0];
            for (int j = 0; j < n; j++) {
                int temp = dp[j + 1];
                if (sChar[i] == tChar[j]) {
                    dp[j + 1] = pre + 1;
                } else {
                    dp[j + 1] = Math.max(dp[j], dp[j + 1]);
                }
                pre = temp;
            }
        }
        return dp[n];
    }


    public void traceBack(int[][] dp, char[] arr1, char[] arr2, int i, int j, String lcs_str, Set<String> hs) {
        while (i > 0 && j > 0) {
            if (arr1[i - 1] == arr2[j - 1]) {
                lcs_str += arr1[i - 1];
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j])
                    j--;
                else if (dp[i][j - 1] < dp[i - 1][j])
                    i--;
                else {  // 相等的情况
                    traceBack(dp, arr1, arr2, i - 1, j, lcs_str, hs);
                    traceBack(dp, arr1, arr2, i, j - 1, lcs_str, hs);
                    return;
                }
            }
        }
        hs.add(new StringBuilder(lcs_str).reverse().toString());
        //输出最长公共子序列
    }


    /**
     * 最长连续子串
     *
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
