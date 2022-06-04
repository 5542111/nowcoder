public class o0009numSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int tempMulti = 1;
        int i = 0, j = 0;
        int res = 0;
        while (j < nums.length) {
            tempMulti *= nums[j]; //前缀积
            while (i <= j && tempMulti >= k) {
                tempMulti /= nums[i];
                i++;
            }
            res += j - i + 1;
            j++;
        }
        return res;
    }
}
