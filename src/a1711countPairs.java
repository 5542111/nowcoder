import java.util.HashMap;
import java.util.Map;

public class a1711countPairs {

    public static void main(String[] args) {
        System.out.println(new a1711countPairs().countPairs(new int[]{1, 3, 5, 7, 9}));
    }

    public int countPairs(int[] deliciousness) {
        long res = 0;
        for (int i = 0; i < deliciousness.length - 1; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                if (isPowerOfTwo(deliciousness[i] + deliciousness[j])) res++;
            }
        }

        return (int) (res % 100000007);
    }

    private boolean isPowerOfTwo(int num) {
        return num > 0 && (num & (num - 1)) == 0;
    }

    private boolean isPowerOfTwo2(int num) {
        return num > 0 && (1 << 30 % num) == 0;
    }


    public int countPairs2(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int i : deliciousness) {
            maxVal = Math.max(maxVal, i);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int val : deliciousness) {
            for (int i = 1; i <= maxSum; i = i << 1) {
                int count = map.getOrDefault(i - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        return pairs;
    }
}
