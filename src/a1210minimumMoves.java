import java.util.LinkedList;
import java.util.Queue;

public class a1210minimumMoves {
    public int minimumMoves(int[][] grid) {
        int[][] dirs = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int n = grid.length;
        boolean[][][] visit = new boolean[n][n][2];
        Queue<int[]> queue = new LinkedList<>();
        visit[0][0][0] = true;
        queue.add(new int[]{0, 0, 0});
        for (int step = 1; !queue.isEmpty(); step++) {
            Queue<int[]> tmp = queue;
            queue = new LinkedList<>();
            for (int[] t : tmp) {
                for (int[] dir : dirs) {
                    int x = t[0] + dir[0], y = t[1] + dir[1], s = t[2] ^ dir[2];
                    int x2 = x + s, y2 = y + (s ^ 1); //蛇头位置
                    if (x2 < n && y2 < n && !visit[x][y][s] && grid[x][y] == 0 && grid[x2][y2] == 0 && (dir[2] == 0 || grid[x + 1][y + 1] == 0)) {
                        if (x == n - 1 && y == n - 2) {
                            return step;
                        }
                        visit[x][y][s] = true;
                        queue.add(new int[]{x, y, s});
                    }
                }
            }
        }
        return -1;
    }
}
