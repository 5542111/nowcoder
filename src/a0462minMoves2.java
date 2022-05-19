import java.util.Arrays;

public class a0462minMoves2 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int avg = nums[nums.length / 2];
        int res=0;
        for (int i = 0; i < nums.length/2; i++) {
             res+=nums[nums.length-1-i]-nums[i];
        }
        return res;
    }




}
