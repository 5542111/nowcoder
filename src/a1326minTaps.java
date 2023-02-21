import java.util.Arrays;
import java.util.Comparator;

public class a1326minTaps {
    public int minTaps(int n, int[] ranges) {
        int[][] rg = new int[n + 1][2];
        for (int i = 0; i < ranges.length; i++) {
            rg[i][0] = Math.max(0, i - ranges[i]);
            rg[i][1] = Math.min(n, i + ranges[i]);
        }
        Arrays.sort(rg, Comparator.comparingInt(o -> o[0]));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int[] ints : rg) {
            int start = ints[0], end = ints[1];
            if (dp[start] == Integer.MAX_VALUE) {
                return -1;
            }
            for (int i = start; i <= end; i++) {
                dp[i] = Math.min(dp[start] + 1, dp[i]);
            }
        }

        return dp[n];
    }
}
