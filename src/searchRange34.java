
import java.util.ArrayList;
import java.util.List;

public class searchRange34 {
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * @param nums
     * @param target
     * @return
     */
    //时空都 o(n)的算法
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) list.add(i);
        }

        if (list.size() == 0) {
            return res;
        }

        res[0] = list.get(0);
        res[1] = list.get(list.size() - 1);

        return res;
    }

    //二分
    public int[] searchRange1(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }
    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
