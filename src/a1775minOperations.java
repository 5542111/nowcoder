public class a1775minOperations {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length * 6 < nums2.length || nums2.length * 6 < nums1.length) {
            return -1;
        }
        int[] count1 = new int[7];
        int[] count2 = new int[7];
        int diff = 0;
        for (int i : nums1) {
            count1[i]++;
            diff += i;
        }
        for (int i : nums2) {
            count2[i]++;
            diff -= i;
        }
        if (diff == 0) {
            return 0;
        }
        return diff > 0 ? help(count2, count1, diff) : help(count1, count2, -diff);
    }

    public int help(int[] h1, int[] h2, int diff) {
        int[] h = new int[7];
        for (int i = 1; i < 7; ++i) {
            h[6 - i] += h1[i];
            h[i - 1] += h2[i];
        }
        int res = 0;
        for (int i = 5; i > 0 && diff > 0; --i) {
            int t = Math.min((diff + i - 1) / i, h[i]);
            res += t;
            diff -= t * i;
        }
        return res;
    }
}
