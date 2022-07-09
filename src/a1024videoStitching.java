import java.util.Arrays;

public class a1024videoStitching {
    public static void main(String[] args) {
        System.out.println(new a1024videoStitching().videoStitching2(
                new int[][]{
                        {0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}
                }, 10
        ));
    }

    public int videoStitching(int[][] clips, int time) {
        int[] dp = new int[time + 1];
        Arrays.fill(dp, time + 1);
        for (int i = 1; i < time + 1; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[time] == time + 1 ? -1 : dp[time];
    }

    public int videoStitching2(int[][] clips, int time) {
        int[] rightMost = new int[time];
        int last = 0;
        int res = 0;
        int prev = 0;
        for (int[] clip : clips) {
            if (clip[0] < time) {
                rightMost[clip[0]] = Math.max(rightMost[clip[0]], clip[1]);
            }
        }

        for (int i = 0; i < time; i++) {
            last = Math.max(last, rightMost[i]);
            if (i == last) {
                return -1;
            }
            if (i == prev) {
                res++;
                prev = last;
            }
        }
        return res;
    }
}
