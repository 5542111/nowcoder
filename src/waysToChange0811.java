public class waysToChange0811 {
    public int waysToChange(int n) {
        int mod = 1000000007;
        int[] dp = new int[n+1];
        int[] coins = new int[]{1,5, 10, 25};

        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int coin: coins) {
                if(i - coin < 0) break;
                dp[i] = (dp[i] + dp[i - coin]) % mod;
            }
        }

        return dp[n];

    }
}
