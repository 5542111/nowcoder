public class a0795numSubarrayBoundedMax {
    public static void main(String[] args) {
        System.out.println(new a0795numSubarrayBoundedMax().numSubarrayBoundedMax(
                new int[]{73,55,36,5,55,14,9,7,72,52}, 32, 69
        ));
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;
        int i = -1;
        int j = -1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] >= left && nums[k] <= right) {
                i = k;
            } else if (nums[k] > right) {
                j = k;
                i = -1;
            }
            if (i != -1) {
                count += i - j;
            }
        }
        return count;
    }
}
