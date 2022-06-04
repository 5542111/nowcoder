import java.util.Arrays;

public class a2171minimumRemoval {
    /**
     * https://leetcode.cn/problems/removing-minimum-number-of-magic-beans/solution/na-chu-zui-shao-shu-mu-de-mo-fa-dou-xian-te3m/
     * 题解好理解
     * @param beans
     * @return
     */
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long sum = Arrays.stream(beans).mapToLong(Long::valueOf).sum();
        long res = sum;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, sum - (long) beans[i] * (n - i));
        }
        return res;
    }

}
