public class a0213rob {

    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        return Math.max(robHelper(nums,0,nums.length-1),robHelper(nums,1,nums.length));
    }

    public int robHelper(int[] nums, int start, int end) {

        int dp0 = 0;
        int dp1 = nums[start];
        int res = dp1;
        for (int i = start + 2; i <= end - start; i++) {
            res = Math.max(dp1, dp0 + nums[i - 1]);
            dp0 = dp1;
            dp1 = res;
        }
        return res;
    }
}
