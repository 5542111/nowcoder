import java.util.Arrays;

public class a0324wiggleSort {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int left = (nums.length - 1) / 2;
        int right = (nums.length - 1);
        System.out.println(left + " " + right);

        int[] res = new int[nums.length];
        int mid = left;
        int index = 0;
        while (left >= 0 || right > mid) {
            if ((index & 1) == 0) {
                res[index++] = nums[left--];
            } else {
                res[index++] = nums[right--];
            }

        }
        System.arraycopy(res, 0, nums, 0, nums.length);
    }

    public void wiggleSort2(int[] nums) {
        int[] bucket = new int[5001];
        for (int num : nums) {
            bucket[num]++;
        }

        int top = 5000;

        for (int i = 1; i < nums.length; i += 2) {
            while (bucket[top] == 0) top--;

            nums[i] = top;
            bucket[top]--;

        }
        for (int i = 0; i < nums.length; i += 2) {
            while (bucket[top] == 0) top--;

            nums[i] = top;
            bucket[top]--;
        }
    }
}
