import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class poolSize1619 {
    public int[] pondSizes(int[][] land) {
        // 边界条件
        if (land == null || land.length == 0 || land[0].length == 0) {
            return null;
        }
        // 定义边界开始dfs
        int m = land.length;
        int n = land[0].length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = dfs(land, i, j);
                if (tmp != 0) {
                    res.add(tmp);
                }
            }
        }
        // 处理答案List转int，并排序
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        Arrays.sort(ans);
        return ans;
    }

    // dfs搜索
    private int dfs(int[][] land, int i, int j) {
        // 边界条件
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] != 0) {
            return 0;
        }
        // 做一些处理
        land[i][j] = 1;
        int size = dfs(land, i - 1, j - 1) +
                dfs(land, i - 1, j) +
                dfs(land, i - 1, j + 1) +
                dfs(land, i, j - 1) +
                dfs(land, i, j + 1) +
                dfs(land, i + 1, j - 1) +
                dfs(land, i + 1, j) +
                dfs(land, i + 1, j + 1) + 1;
        return size;
    }
}
