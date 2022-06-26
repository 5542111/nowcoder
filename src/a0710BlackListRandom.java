import java.util.*;

public class a0710BlackListRandom {
    private Random random;
    private Map<Integer, Integer> black2White;
    private Integer whiteLen;

    /**
     * https://leetcode.cn/problems/random-pick-with-blacklist/solution/hei-ming-dan-zhong-de-sui-ji-shu-by-jian-8qgj/
     * @param n
     * @param blacklist
     */
    public a0710BlackListRandom(int n, int[] blacklist) {
        black2White = new HashMap<>();
        random = new Random();
        whiteLen = n - blacklist.length;


        int[] black = new int[blacklist.length];
        for (int value : blacklist) {
            if (value >= whiteLen) {
                black[value - whiteLen] = 1;
            }
        }
        int pos = 0;
        for (int value : blacklist) {
            if (value < whiteLen) {
                while (black[pos] == 1) {
                    pos++;
                }
                black2White.put(value, pos + whiteLen);
                pos++;
            }
        }

    }

    public int pick() {
        int v = random.nextInt(whiteLen);
        return black2White.getOrDefault(v, v);
    }
}
