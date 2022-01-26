public class a2091minimumDeletions {

    public int minimumDeletions(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        int size = nums.length;
        if (maxIndex < minIndex) {
            int temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
        }
        int res = Math.min(maxIndex + 1, size - minIndex);
        res = Math.min(res, minIndex + 1 + size - maxIndex);
        return res;
    }
}
