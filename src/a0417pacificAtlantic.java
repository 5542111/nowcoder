import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a0417pacificAtlantic {
    private boolean[][] pacific;
    private boolean[][] atlantic;
    private List<List<Integer>> res;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        pacific = new boolean[heights.length][heights[0].length];
        atlantic = new boolean[heights.length][heights[0].length];
        res = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            dfs(i, 0, pacific, heights);
            dfs(i, heights[0].length - 1, atlantic, heights);
        }
        for (int i = 0; i < heights[0].length; i++) {
            dfs(0, i, pacific, heights);
            dfs(heights.length - 1, i, atlantic, heights);
        }
        return res;
    }

    private void dfs(int row, int col, boolean[][] oceanUsed, int[][] heights) {
        if (oceanUsed[row][col]) return;

        oceanUsed[row][col] = true;

        if (pacific[row][col] && atlantic[row][col]) res.add(Arrays.asList(row, col));

        if (row - 1 >= 0 && heights[row - 1][col] >= heights[row][col]) dfs(row - 1, col, oceanUsed, heights);
        if (col - 1 >= 0 && heights[row][col - 1] >= heights[row][col]) dfs(row, col - 1, oceanUsed, heights);
        if (row + 1 < heights.length && heights[row + 1][col] >= heights[row][col])
            dfs(row + 1, col, oceanUsed, heights);
        if (col + 1 < heights[0].length && heights[row][col + 1] >= heights[row][col])
            dfs(row, col + 1, oceanUsed, heights);

    }
}
