public class sortColors75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                swap(nums, i, ptr);
                ptr++;
            }

        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                swap(nums, i, ptr);
                ptr++;
            }

        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
