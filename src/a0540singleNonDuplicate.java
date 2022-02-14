public class a0540singleNonDuplicate {
    public static void main(String[] args) {
        System.out.println(new a0540singleNonDuplicate().singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    }

    public int singleNonDuplicate(int[] nums) {
        int res = nums[0];
        int left = 1;
        int right = nums.length - 1;
        while (left < right) {
            res ^= (nums[left] ^ nums[right]);
            left++;
            right--;
        }
        return res;
    }

    public int singleNonDuplicate2(int[] nums) {
        //nums 有序
        //如果mid为偶数 mid+1 =mid ^ 1 如果为奇数 依然是 mid ^ 1
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }
}
