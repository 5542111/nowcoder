import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class maxSumRangeQuery1589 {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        final int MODULO = 1000000007;
        int length = nums.length;
        int[] counts = new int[length];
        for (int[] request : requests) {
            int start = request[0], end = request[1];
            counts[start]++;
            if (end + 1 < length) {
                counts[end + 1]--;
            }
        }
        for (int i = 1; i < length; i++) {
            counts[i] += counts[i - 1];
        }
        Arrays.sort(counts);
        Arrays.sort(nums);
        long sum = 0;
        for (int i = length - 1; i >= 0 && counts[i] > 0; i--) {
            sum += (long) nums[i] * counts[i];
        }
        return (int) (sum % MODULO);
    }
    public int maxSumRangeQuery2(int[] nums, int[][] requests) {
        if (nums.length == 0)
            return 0;
        int[][] frequency = new int[nums.length][2];
        for (int i = 0; i < frequency.length; i++) {
            frequency[i][0] = i;
        }
        for (int i = 0; i < requests.length; i++) {
            for (int j = requests[i][0]; j <= requests[i][1]; j++) {
                frequency[j][1]++;
            }
        }
        System.out.println("排序前");
        for (int i = 0; i < nums.length; i++) {

            System.out.println(frequency[i][0] + ":" + frequency[i][1]);
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(frequency, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        System.out.println("排序后");
        for (int i = 0; i < nums.length; i++) {

            System.out.println(frequency[i][0] + ":" + frequency[i][1]);
        }
        Arrays.sort(nums);

        long sum=0;
        for (int i = 0; i < nums.length; i++) {
            while(frequency[i][1]-->0)
            {
                sum+=nums[nums.length-1-i];
            }

        }
        return (int)sum%1000000007;
    }
}
