import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class a1814countNicePairs {
    public int countNicePairs(int[] nums) {
        int mod = 1000000007;
        int res = 0;
        Map<Integer, Integer> numCountMap = new HashMap<>();

        for (int num : nums) {
            int temp = num;
            int reverse = reverse(temp);

            res = (res + numCountMap.getOrDefault(num - reverse, 0)) % mod;
            numCountMap.put(num - reverse, numCountMap.getOrDefault(num - reverse, 0) + 1);
        }


        return res;
    }


    private int reverse(int num) {
        return Integer.parseInt(new StringBuilder().append(num).reverse().toString());
    }
}
