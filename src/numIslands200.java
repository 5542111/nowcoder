import java.util.ArrayList;
import java.util.List;

public class numIslands200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        if (grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        boolean[][] gridUsed = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!gridUsed[i][j] && grid[i][j] == '1') {
                    dfs(grid, gridUsed, i, j);
                    res++;
                }
            }
        }
        return res;

    }

    private void dfs(char[][] grid, boolean[][] gridUsed, int i, int j) {
        for (int[] loc : getNears(i, j, grid.length, grid[0].length)) {
            if (grid[loc[0]][loc[1]] == '1' && !gridUsed[loc[0]][loc[1]]) {
                gridUsed[loc[0]][loc[1]] = true;
                dfs(grid, gridUsed, loc[0], loc[1]);
            }
        }
    }

    private List<int[]> getNears(int i, int j, int xLength, int yLength) {
        List<int[]> list = new ArrayList<>();
        if (i - 1 >= 0) list.add(new int[]{i - 1, j});
        if (i + 1 < xLength) list.add(new int[]{i + 1, j});
        if (j - 1 >= 0) list.add(new int[]{i, j - 1});
        if (j + 1 < yLength) list.add(new int[]{i, j + 1});
        return list;
    }
}
