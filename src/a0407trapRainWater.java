import java.util.Comparator;
import java.util.PriorityQueue;

public class a0407trapRainWater {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) return 0;
        int row = heightMap.length;
        int col = heightMap[0].length;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        for (int i = 0; i < col; i++) {
            pq.add(new int[]{0, i, heightMap[0][i]});
            pq.add(new int[]{row - 1, i, heightMap[row - 1][i]});
            visited[0][i] = true;
            visited[row - 1][i] = true;
        }
        for (int i = 0; i < row; i++) {
            pq.add(new int[]{i, 0, heightMap[i][0]});
            pq.add(new int[]{i, col - 1, heightMap[i][col - 1]});
            visited[i][0] = true;
            visited[i][col - 1] = true;
        }

        int res = 0;
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            for (int i = 0; i < 4; i++) {
                int indexX = poll[0] + dx[i];
                int indexY = poll[1] + dy[i];
                if (indexX >= 0 && indexX < row && indexY >= 0 && indexY < col && !visited[indexX][indexY]) {
                    if (poll[2] > heightMap[indexX][indexY]) {
                        res += poll[2] - heightMap[indexX][indexY];
                    }
                    pq.add(new int[]{indexX, indexY, Math.max(poll[2], heightMap[indexX][indexY])});
                    visited[indexX][indexY] = true;
                }
            }
        }
        return res;
    }
}
