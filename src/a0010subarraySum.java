import java.util.HashMap;
import java.util.Map;

public class a0010subarraySum {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        int res = 0;
        int sum = 0;
        hashMap.put(0, 1);
        for (int num : nums) {
            sum += num;
            res += hashMap.getOrDefault(sum - k, 0);
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
