
public class a0556nextGreaterElement {
    public static void main(String[] args) {
        System.out.println(new a0556nextGreaterElement().nextGreaterElement(12443322));
    }

    public int nextGreaterElement(int n) {
        String num = String.valueOf(n);
        char[] nums = num.toCharArray();
        int i;
        for (i = num.length() - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        System.out.println("pre:" + i);
        if (i >= 0) {
            int right = nums.length - 1;
            while (nums[right] <= nums[i]) {
                right--;
            }
            swap(nums, i, right);

        }
        reverse(nums, i + 1);

        long value = Long.parseLong(String.valueOf(nums));
        if (value > Integer.MAX_VALUE || value <= n) {
            return -1;
        }

        return (int) value;
    }


    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(char[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
