import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class a0532findPairs {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (left < nums.length && (nums[left] < nums[i] + k || left <= i)) {
                    left++;
                }
                if (left < nums.length && nums[left] == nums[i] + k) {
                    res++;
                }
            }
        }

        return res;
    }

    public int findPairs2(int[] nums, int k) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }

}
