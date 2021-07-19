public class a0695maxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int num=0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int sum=dfs(grid, i, j);
                    num = Math.max(sum, num);
                }
            }
        }


        return num;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (!isInArea(grid, i, j)) {
            return 0;
        }

        if (grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 2;

        return 1 + dfs(grid, i - 1, j) +
                dfs(grid, i + 1, j) +
                dfs(grid, i, j - 1) +
                dfs(grid, i, j + 1);


    }

    private boolean isInArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
