public class a1250isGoodArray {
    public boolean isGoodArray(int[] nums) {
        int divisor = nums[0];
        for (int num : nums) {
            divisor = gcd(divisor, num);
            if (divisor == 1) {
                break;
            }
        }
        return divisor == 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
