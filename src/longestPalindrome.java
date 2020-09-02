public class longestPalindrome {
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
                        dp[i][j]=true;
                    }
                    else {
                        dp[i][j]=dp[i-1][j+1];
                    }
                }
                else {
                    dp[i][j]=false;
                }
                if (dp[i][j]){
                    int curLen=i-j+1;
                    if (curLen>maxLen)
                    {
                        maxLen=curLen;
                        start=j;
                    }
                }

            }
        }
        return s.substring(start,start+maxLen);
    }
}
