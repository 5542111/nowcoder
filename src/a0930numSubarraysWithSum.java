import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class a0930numSubarraysWithSum {
    public static void main(String[] args) {
        System.out.println(new a0930numSubarraysWithSum().numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int res = 0;
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
            preSum += nums[i];
            res += preSumMap.getOrDefault(preSum-goal,0);
        }
        return res;
    }

}
