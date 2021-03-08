import java.util.ArrayList;

public class findCheapestPrice787 {
    public static void main(String[] args) {
        System.out.println(new findCheapestPrice787().findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
    }



    private int[][] graph;
    private boolean[] visited;
    private int res = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        K = Math.min(K, n - 2);

        this.graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        this.visited = new boolean[n];
        // 开始深度优先遍历，注意：这里传 K + 1，这是因为 K 次经停，总共 K + 1 个站
        dfs(src, dst, K + 1, 0);

        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    private void dfs(int src, int dst, int k, int cost) {
        if (src == dst) {
            res = cost;
            return;
        }

        if (k == 0) {
            return;
        }

        for (int i = 0; i < graph[src].length; i++) {
            if (graph[src][i] > 0) {
                if (visited[i]) {
                    continue;
                }

                // 剪枝：跳过可能产生较高费用的路径，从而选出最少价格
                if (cost + graph[src][i] > res) {
                    continue;
                }

                visited[i] = true;
                dfs(i, dst, k - 1, cost + graph[src][i]);
                visited[i] = false;
            }
        }
    }

}
