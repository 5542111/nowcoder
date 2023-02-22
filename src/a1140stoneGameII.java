import java.util.HashMap;
import java.util.Map;

public class a1140stoneGameII {
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + piles[i];
        }
        return dfs(new HashMap<>(), piles, preSum, 0, 1);
    }

    private int dfs(Map<Integer, Integer> memo, int[] piles, int[] preSum, int index, int m) {
        if (index == piles.length) {
            return 0;
        }

        int key = index * 2 + m;
        if (!memo.containsKey(key)) {
            int max = Integer.MIN_VALUE;
            for (int x = index; x <= 2 * m; x++) {
                if (index + x > piles.length) {
                    break;
                }

                max = Math.max(max, preSum[index + x] - preSum[index] - dfs(memo, piles, preSum, index + x, Math.max(x, m)));
            }
        }
        return memo.get(key);
    }
    public int stoneGameII2(int[] piles){
        int len = piles.length, sum = 0;
        int[][] dp = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= len; M++) {
                if (i + 2 * M >= len) {
                    dp[i][M] = sum;
                } else {
                    for (int x = 1; x <= 2 * M; x++) {
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
