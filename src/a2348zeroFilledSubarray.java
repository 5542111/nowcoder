public class a2348zeroFilledSubarray {
    public static void main(String[] args) {
        System.out.println(new a2348zeroFilledSubarray().zeroFilledSubarray(new int[]{0, 0, 0, 2, 0, 0}));
    }

    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;

        long zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
                ans += zeroCount;
            } else {
                zeroCount = 0;
            }
        }

        return ans;
    }

    //超时
    public long zeroFilledSubarray2(int[] nums) {
        long ans = 0;

        int left = 0;

        int right = 0;

        StringBuilder sb = new StringBuilder();
        while (left < nums.length) {
            if (nums[left] == 0) {
                while (right < nums.length && nums[right] == 0) {
                    ans++;
                    right++;
                }
                left++;
                right = left;
            } else {
                left++;
                right = left;
            }
        }

        return ans;
    }
}