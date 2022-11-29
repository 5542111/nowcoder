import java.util.ArrayList;
import java.util.List;

public class o0112longestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                List<Integer> res = new ArrayList<>();
                res.add(matrix[i][j]);
                max = Math.max(dfs(matrix, new boolean[matrix.length][matrix[0].length], res, matrix[i][j], i, j), max);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, boolean[][] matrixUsed, List<Integer> res, int value, int i, int j) {
        System.out.println(res);
        List<int[]> nears = getNears(matrix, matrixUsed, i, j, value);
        if (nears.size() == 0) {
            return res.size();
        }
        for (int[] ints : nears) {
            if (!matrixUsed[ints[0]][ints[1]]) {
                res.add(matrix[ints[0]][ints[1]]);
                matrixUsed[ints[0]][ints[1]] = true;
                dfs(matrix, matrixUsed, res, matrix[ints[0]][ints[1]], ints[0], ints[1]);
                matrixUsed[ints[0]][ints[1]] = false;
                res.remove(res.size() - 1);
            }
        }
        return res.size();
    }


    private List<int[]> getNears(int[][] matrix, boolean[][] matrixUsed, int i, int j, int value) {
        List<int[]> list = new ArrayList<>();
        if (i - 1 >= 0 && !matrixUsed[i - 1][j] && value < matrix[i - 1][j]) list.add(new int[]{i - 1, j});
        if (i + 1 < matrix.length && !matrixUsed[i + 1][j] && value < matrix[i + 1][j]) list.add(new int[]{i + 1, j});
        if (j - 1 >= 0 && !matrixUsed[i][j - 1] && value < matrix[i][j - 1]) list.add(new int[]{i, j - 1});
        if (j + 1 < matrix[0].length && !matrixUsed[i][j + 1] && value < matrix[i][j + 1])
            list.add(new int[]{i, j + 1});
        return list;
    }


    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    public int longestIncreasingPath2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int row, int column, int[][] memo) {
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        ++memo[row][column];
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }


}
