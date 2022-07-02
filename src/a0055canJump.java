public class a0055canJump {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, nums[i] + i);
                if (rightMost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public int canJump2(int[] nums) {
        int n = nums.length - 1;
        int res = 0;
        while (n > 0) {
            for (int i = 0; i < n; i++) {
                if (i + nums[i] >= n) {
                    n = i;
                    res++;
                    break;
                }
            }
        }

        return res;
    }

    public int canJump3(int[] nums) {
        int n = nums.length;
        int end = 0;
        int maxPosition = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                count++;
            }
        }
        return count;
    }
}
