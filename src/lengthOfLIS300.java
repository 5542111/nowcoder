import java.util.*;

public class lengthOfLIS300 {
    public static void main(String[] args) {
        System.out.println(new lengthOfLIS300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int[] dp = new int[nums.length];
        dp[0] = 1;

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }

    public int[] LIS (int[] arr) {
        // write code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] maxLen = new int[arr.length];
        for(int i = 0; i < arr.length; i ++){
            if(list.isEmpty() || list.get(list.size()-1) <= arr[i]){
                list.add(arr[i]);
                maxLen[i] = list.size();
            }else{
                int tmp = Collections.binarySearch(list,arr[i]);
                if(tmp < 0) tmp = -tmp-1;
                list.set(tmp, arr[i]);
                maxLen[i] = tmp+1;
            }
        }
        int[] lis = new int[list.size()];
        for(int i = lis.length-1, k = maxLen.length-1; i >= 0; k --){
            if(maxLen[k]==i+1){
                lis[i] = arr[k];
                i --;
            }
        }
        return lis;
    }

}
