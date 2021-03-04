public class numsOfBST96 {

    public int numTrees(int n) {
        long c=1;

        for (int i = 0; i < n; i++) {
            c=c*(4*i+2)/(i+2);
        }
        return (int)c;
    }

    public int numTrees1(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for (int i = 2; i <n+1 ; i++) {
            for (int j = 1; j <n+1 ; j++) {
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
