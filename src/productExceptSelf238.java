public class productExceptSelf238 {
    /**
     * 时间 o(n^2) 空间 o(n)
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    temp *= nums[j];
                }
            }
            res[i] = temp;
        }

        return res;
    }

    /**
     * 时间 o(n) 空间 o(1)
     * @param nums
     * @return
     */
    public static int[] productExceptSelf2(int[] nums) {
        int total = 1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                total *= nums[i];
            } else {
                count++;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (count > 1) {
                    nums[i] = 0;
                } else {
                    nums[i] = total;
                }
            } else {
                if (count > 0) {
                    nums[i] = 0;
                } else {
                    nums[i] = total / nums[i];
                }
            }

        }
        return nums;
    }
}
