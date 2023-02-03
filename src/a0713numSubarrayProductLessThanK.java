public class a0713numSubarrayProductLessThanK {
    public static void main(String[] args) {
        new a0713numSubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0, right = 0;
        int count = 0;
        int multi = 1;
        while (right < nums.length) {
            multi *= nums[right];
            while (multi >= k) {
                multi /= nums[left++];
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
