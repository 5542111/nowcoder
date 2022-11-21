
public class LCS03largestArea {
    public static void main(String[] args) {
        System.out.println(new LCS03largestArea().largestArea(new String[]{
                "110", "231", "221"
        }));
    }

    private int res = 0;
    boolean flag = false;

    int count = 0;

    public int largestArea(String[] grid) {
        char[][] grids = new char[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            grids[i] = grid[i].toCharArray();
        }
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                flag = true;
                count = 0;
                if (grids[i][j] >= '0' && grids[i][j] != '6') {
                    dfs(grids, i, j, grids[i][j]);
                    if (flag) {
                        res = Math.max(count, res);
                    }
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j, char value) {
        if (outOfBound(grid, i, j)) {
            flag = false;
            return;
        }
        if (grid[i][j] != value) {
            return;
        }
        grid[i][j] = '6';
        count++;
        dfs(grid, i + 1, j, value);
        dfs(grid, i - 1, j, value);
        dfs(grid, i, j + 1, value);
        dfs(grid, i, j - 1, value);
    }

    private boolean outOfBound(char[][] grid, int i, int j) {
        return i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0';
    }
}
