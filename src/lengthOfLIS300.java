public class lengthOfLIS300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int[] dp = new int[nums.length];
        dp[0] = 1;


        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i])
                {
                 dp[i]=Math.max(dp[j],dp[j]+1);
                }


            }

            System.out.println(dp[i]);

        }

        return dp[nums.length-1];
    }

}
