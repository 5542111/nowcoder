import java.util.HashMap;
import java.util.Map;

public class a0873lenLongestFibSubseq {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            numIndexMap.put(arr[i], i);
        }
        int n = arr.length;
        int res = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[i] < 2 * arr[j]; j--) {
                int index = numIndexMap.getOrDefault(arr[i] - arr[j], -1);
                if (index == -1) continue;
                dp[j][i] = Math.max(dp[index][j] + 1, 3);
                res = Math.max(dp[j][i], res);
            }
        }

        return res;
    }


    int res;

    public int lenLongestFibSubseq2(int[] arr) {
        res = 0;
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                dfs(arr, i, arr[j], arr[i], 2);
            }
        }

        return res;
    }

    private void dfs(int[] nums, int i, int first, int second, int length) {
        int left = i + 1;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > first + second) {
                right = mid - 1;
            } else {
                if (nums[mid] == first + second) {
                    res = Math.max(res, length + 1);
                    dfs(nums, mid, second, nums[mid], length + 1);
                }
                left = mid + 1;
            }
        }

    }


}
