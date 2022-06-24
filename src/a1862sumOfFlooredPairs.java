
public class a1862sumOfFlooredPairs {

    public int sumOfFlooredPairs(int[] nums) {
        int mod = 1000000007;
        long res = 0;
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] preNum = new int[max + 1];
        for (int num : nums) {
            preNum[num]++;
        }
        for (int i = 1; i < max + 1; i++) {
            preNum[i] += preNum[i - 1];
        }

        for (int i = 1; i < max + 1; i++) {
            //被除数的个数
            long xCount = preNum[i] - preNum[i - 1];
            if (xCount == 0) continue;
            //相隔 相同大小距离的 floor 值是一致的 所以可以合并统计
            for (int j = i; j < max + 1; j += i) {
                long yCount = preNum[Math.min(j + i - 1, max)] - preNum[j - 1];
                res = (res + (j / i) * yCount * xCount) % mod;
            }
        }
        return (int) res;
    }
}
