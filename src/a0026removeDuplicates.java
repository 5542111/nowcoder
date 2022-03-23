public class a0026removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 1, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
