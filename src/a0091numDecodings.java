
public class a0091numDecodings {
    public static void main(String[] args) {
        System.out.println(new a0091numDecodings().numDecodings("000000"));
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        //base case
        dp[0] = 1;
        for (int i = 1; i < s.length() + 1; i++) {

            //状态转移 这里是考虑 只取一位数的情况
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            //这里是 是考虑 取2位数 且 满足不大于26的情况
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2)-'0') * 10 +( s.charAt(i - 1)-'0') <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
