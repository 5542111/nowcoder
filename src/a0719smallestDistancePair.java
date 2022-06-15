import java.util.Arrays;
import java.util.PriorityQueue;

public class a0719smallestDistancePair {
    /**
     * 优先队列 解决 第k小 数对
     * 时间 o(n log n) 空间 o(n log n)
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                pq.offer(Math.abs(nums[i] - nums[j]));
            }
        }
        int res = -1;
        for (int i = 0; i < k; i++) {
            res = pq.poll();
        }

        return res;
    }

    /**
     * 二分法 解决 第k小 数对
     * https://leetcode.cn/problems/find-k-th-smallest-pair-distance/solution/by-ac_oier-o4if/
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int j = binarySearch(nums, i, nums[i] - mid);
                cnt += i - j;
            }
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    private int binarySearch(int[] nums, int end, int target) {
        int left = 0, right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


}
