public class findLengthOfLCIS674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0)
        {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0]=1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                if (dp[i] > max) {
                    max = dp[i];
                }
            } else {
                dp[i] = 1;
            }
        }

        return max;
    }
}
