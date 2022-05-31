import java.util.Arrays;

public class a2195minimalKSum {
    public static void main(String[] args) {

    }

    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long res = 0;
        long count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (count < nums[i]) {
                int cnt = Math.min((int) (nums[i] - count), k);
                res += (2L * count + cnt - 1) * cnt / 2;
                k -= cnt;
            }
            count = nums[i] + 1;
        }
        //如果k还有剩余在nums最大值的后面的计算
        if (k > 0) {
            res += (2L * count + k - 1) * k / 2;
        }
        return res;
    }
}
