package doubleLeetWeek;

public class isPossibleToCutPath {
    public static void main(String[] args) {
        new isPossibleToCutPath().isPossibleToCutPath(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        });
    }

    public boolean isPossibleToCutPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return !dfs(0, 0, grid, m, n) || !dfs(0, 0, grid, m, n);
    }

    private boolean dfs(int x, int y, int[][] grid, int m, int n) {

        if (x == m - 1 && y == n - 1) {
            return true;
        }
        grid[x][y] = 0;
        return (x < m - 1 && grid[x + 1][y] == 1 && dfs(x + 1, y, grid, m, n))
                || (y < n - 1 && grid[x][y + 1] == 1 && dfs(x, y + 1, grid, m, n));
    }
}
