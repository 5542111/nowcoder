import java.lang.reflect.Array;
import java.util.Arrays;

public class coinChange322 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    private int[][] memo;
    private int[] coins;

    public int coinChange2(int[] coins, int amount) {
        this.memo = new int[coins.length + 1][amount + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        this.coins = coins;
        int ans = dfs(coins.length - 1, amount);

        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }

    private int dfs(int index, int amount) {
        if (index < 0) {
            if (amount == 0) {
                return 0;
            } else {
                return Integer.MAX_VALUE / 2;
            }
        }
        if (memo[index][amount] != -1) {
            return memo[index][amount];
        }
        if (amount < coins[index]) {
            return dfs(index - 1, amount);
        }
        return memo[index][amount] = Math.min(dfs(index - 1, amount), dfs(index, amount - coins[index]) + 1);
    }



}
