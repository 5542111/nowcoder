import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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

        int[][] grid=new int[text1.length()+1][text2.length()+1];

        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }
        Set<String> hs=new TreeSet<>();
        traceBack(dp,text1.toCharArray(),text2.toCharArray(),text1.length(),text2.length(),"",hs);
        System.out.println(hs);
        for (int i = 0; i < text1.length() + 1; i++) {
            for (int j = 0; j < text2.length() + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[text1.length()][text2.length()];
    }

    public  void traceBack(int [][] dp, char [] arr1, char [] arr2, int i, int j, String lcs_str,Set<String> hs)  {
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
                    traceBack(dp, arr1, arr2, i - 1, j, lcs_str,hs);
                    traceBack(dp, arr1, arr2, i, j - 1, lcs_str,hs);
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
