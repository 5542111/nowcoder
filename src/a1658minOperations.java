public class a1658minOperations {
    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum < x) {
            return -1;
        }


        int right = 0;

        int lSum = 0;
        int rSum = sum;


        int ans = len + 1;
        for (int left = -1; left < len; left++) {
            if (left != -1) {
                lSum += nums[left];
            }

            while (right < len && lSum + rSum > x) {
                rSum -= nums[right];
                ++right;
            }

            if (lSum + rSum == x) {
                ans = Math.min(ans, (left + 1) + (len - right));
            }
        }

        return ans > len ? -1 : ans;
    }
}
