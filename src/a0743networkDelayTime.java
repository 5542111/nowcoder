import java.util.Arrays;

public class a0743networkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = 0x3FFFFFFF;
        //有向图数组
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], INF);
        }
        for (int[] time : times) {
            int x = time[0] - 1, y = time[1] - 1;
            grid[x][y] = time[2];
        }
        //距离数组
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        //k为出发点
        dist[k - 1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && (x == -1 || dist[j] < dist[x])) {
                    x = j;
                }
            }
            used[x] = true;
            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], dist[x] + grid[x][j]);
            }
        }

        int max = Arrays.stream(dist).max().getAsInt();

        return max == INF ? -1 : max;

    }
}
