
public class a1043maxSumAfterPartitioning {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int res = 0;
        if (arr.length == 0) return res;
        int[] dp = new int[arr.length];
        for (int i = 1; i <= k; i++) {
            dp[i - 1] = getMaxValue(arr, 0, i - 1) * i;
        }
        for (int i = k; i < arr.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + getMaxValue(arr, i - j + 1, i) * j);
            }
        }
        return dp[arr.length - 1];
    }

    private int getMaxValue(int[] arr, int start, int end) {
        int max = 0;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
