import java.util.Set;

public class findMaximumXOR421 {
    public static void main(String[] args) {

    }
    public int findMaximumXOR(int[] nums) {
        //暴力
        int Max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                    int xor=nums[i]^nums[j];
                    if (xor>Max)
                    {
                        Max=xor;
                    }
            }
        }
        return Max;
    }
}
