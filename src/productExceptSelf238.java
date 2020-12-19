public class productExceptSelf238 {
    /**
     * 时间 o(n^2) 空间 o(n)
     *
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
     *
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

    /**
     * 时间 o(n) 空间 o(1)  除开res的空间
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf3(int[] nums) {
        int[] res = new int[nums.length];


        //统计 每个元素左边的乘积
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        //res已经做了左边的乘积... 故重复做右边的乘积
        int R = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = res[i] * R;
            R = R * nums[i];
        }

        return res;

    }

}
