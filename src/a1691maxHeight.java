import java.util.Arrays;
import java.util.Comparator;

public class a1691maxHeight {
    public int maxHeight(int[][] cuboids) {
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        Arrays.sort(cuboids, Comparator.comparingInt(arr -> (arr[0] + arr[1] + arr[2])));
        int res = 0;
        int[] dp = new int[cuboids.length];
        for (int i = 0; i < cuboids.length; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[i][0] >= cuboids[j][0] &&
                        cuboids[i][1] >= cuboids[j][1] &&
                        cuboids[i][2] >= cuboids[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
