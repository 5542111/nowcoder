import java.util.HashSet;
import java.util.Set;

public class longestConsecutive128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        int ans = 0;
        for (Integer num : hs) {
            if (!hs.contains(num - 1)) {
                int curNum = num;
                int curCount = 1;
                while (hs.contains(curNum + 1)) {
                    curCount++;
                    curNum++;
                }

                ans = Math.max(ans, curCount);
            }
        }
        return ans;
    }
}
