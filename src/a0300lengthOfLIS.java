import java.util.ArrayList;
import java.util.Collections;

public class a0300lengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;

        int max = 1;
        for (int i = 1; i < nums.length + 1; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;

    }

    public int binOfDpLengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;

            while (i < j) {
                int mid = (i + j) / 2;
                if (tails[mid] < num) i = mid + 1;
                else j=mid;
            }
            tails[i]=num;
            if (res==j) res++;
        }

        return res;
    }


    public int[] LIS (int[] nums) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        int[] maxLen = new int[nums.length];
        for(int i = 0; i < nums.length; i ++){
            if(list.isEmpty() || list.get(list.size()-1) <= nums[i]){
                list.add(nums[i]);
                maxLen[i] = list.size();
            }else{
                int tmp = Collections.binarySearch(list,nums[i]);
                if(tmp < 0) tmp = -tmp-1;
                list.set(tmp, nums[i]);
                maxLen[i] = tmp+1;
            }
        }
        int[] lis = new int[list.size()];
        for(int i = lis.length-1, k = maxLen.length-1; i >= 0; k --){
            if(maxLen[k]==i+1){
                lis[i] = nums[k];
                i --;
            }
        }
        return lis;
    }
}
