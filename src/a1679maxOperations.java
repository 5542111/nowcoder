import java.util.Arrays;

public class a1679maxOperations {
    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int L = nums[l], R = nums[r];
            if (L + R == k) {
                ans++;
                l++;
                r--;
            } else if (L + R > k) {
                r--;
            } else {
                l++;
            }
        }
        return ans;
    }
}
