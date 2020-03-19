import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class largestDivisibleSubset368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0)
            return list;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(dp1, -1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        dp1[i] = j;
                    }
                }
            }
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] < dp[index]) {
                index = i;
            }
        }


        while (index != -1) {
            list.add(nums[index]);
            index = dp1[index];
        }

        return list;
    }
}
