import java.util.*;

public class a0018fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int j = nums.length - 1;
        while (j >= 3) {
            for (int i = 0; i < nums.length - 3; i++) {
                int left = i + 1;
                int right = j - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right] + nums[j];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right], nums[j]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            j--;
        }
        Set<List<Integer>> hs = new HashSet<>(res);
        res.clear();
        res.addAll(hs);

        return res;
    }
}
