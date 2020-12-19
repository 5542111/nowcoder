public class moveZeroes283 {
    public static void main(String[] args) {
        int[] res = new int[]{0, 1, 0, 3, 12};
        moveZeroes(res);
    }

    public static void moveZeroes(int[] nums) {
        //left 记录的是非0后第一个0 right 记录 0以后第一个非0
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(left, right, nums);
                left++;
            }
            right++;
        }


        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
