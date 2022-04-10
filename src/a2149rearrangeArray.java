
import java.util.Arrays;
import java.util.Stack;

public class a2149rearrangeArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new a2149rearrangeArray().rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));
    }
    public int[] rearrangeArray(int[] nums) {

        Stack<Integer> odd = new Stack<>();
        Stack<Integer> even = new Stack<>();
        for (int num : nums) {
            if (num  > 0) {
                odd.add(num);
            } else {
                even.add(num);
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i % 2 == 1) {
                nums[i] = even.pop();
            } else {
                nums[i] = odd.pop();
            }
        }
        return nums;
    }

}
