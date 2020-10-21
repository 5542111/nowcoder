public class nthUglyNumber264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int factor2 = 0, factor3 = 0, factor5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[factor2] * 2, Math.min(dp[factor3] * 3, dp[factor5] * 5));
            if (dp[i] == dp[factor2] * 2) factor2++;
            if (dp[i] == dp[factor3] * 3) factor3++;
            if (dp[i] == dp[factor5] * 5) factor5++;

        }
        return dp[n - 1];
    }

    public boolean isUgly(int num) {
        int[] nums = {2, 3, 5};
        for (int i : nums) {
            while (num > 0 && num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] primesUg = new int[primes.length];
        for (int i = 1; i < n; i++) {

            int min=Integer.MAX_VALUE;
            for (int j = 0; j < primes.length ; j++) {
                min=Math.min(min,dp[primesUg[j]]*primes[j]);
            }
            dp[i]=min;
            for (int j = 0; j <primes.length ; j++) {
                if (dp[i]==dp[primesUg[j]]*primes[j])
                {
                    primesUg[j]++;
                }
            }
        }
        return dp[n-1];
    }
}
