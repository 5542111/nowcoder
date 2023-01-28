public class a1664waysToMakeFair {
    public int waysToMakeFair(int[] nums) {
        int count = 0;
        int leftOdd = 0, leftEven = 0;
        int rightOdd = 0, rightEven = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                rightEven += nums[i];
            } else {
                rightOdd += nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                rightEven -= nums[i];
            } else {
                rightOdd -= nums[i];
            }
            if (leftOdd + rightEven == leftEven + rightOdd) {
                count++;
            }
            if ((i & 1) == 0) {
                leftEven += nums[i];
            } else {
                leftOdd += nums[i];
            }
        }
        return count;
    }
}
