public class a0209minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left);
                sum -= nums[left++];
            }

        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
