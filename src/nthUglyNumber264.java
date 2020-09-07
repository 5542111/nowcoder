public class nthUglyNumber264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int factor2 = 0, factor3 = 0, factor5 = 0;
        for (int i = 1 ; i < n; i++) {
            dp[i] = Math.min(dp[factor2]*2,Math.min(dp[factor3]*3,dp[factor5]*5));
            if (dp[i]==dp[factor2]) factor2++;
            if (dp[i]==dp[factor3]) factor3++;
            if (dp[i]==dp[factor5]) factor5++;

        }
        return dp[n - 1];
    }
    public boolean isUgly(int num) {
        int[] nums={2,3,5};
        for(int i:nums){
            while(num>0&&num%i==0)
            {
                num/=i;
            }
        }
        return num==1;
    }
}
