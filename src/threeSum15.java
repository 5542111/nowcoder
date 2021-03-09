import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        //有序后无序再排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) {

            } else {
                int L = i + 1;
                int R = nums.length - 1;

                while (L < R) {
                    int temp=nums[i] + nums[L] + nums[R];
                    if (temp== 0) {
                        res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                        /**
                         *   剔除重复 数据
                         */

                        while (L < R && nums[L] == nums[L + 1]) {
                            L ++;
                        }
                        while (L < R && nums[R] == nums[R - 1]) {
                            R --;
                        }

                        L++;
                        R--;

                    } else if (temp > 0) {
                        R--;
                    } else {
                        L++;
                    }
                }
            }
        }


        return res;
    }
}
