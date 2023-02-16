import java.util.Arrays;

public class a2341numberOfPairs {

    public int[] numberOfPairs(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        int remainNum = 0;

        for (int i : count) {
            if ((i & 1) == 1) {
                remainNum++;
            }
        }


        return new int[]{(nums.length - remainNum) / 2, remainNum};
    }
}
