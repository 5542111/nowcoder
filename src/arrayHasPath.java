import java.util.ArrayList;
import java.util.List;

public class arrayHasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] chars = new char[rows][cols];
        boolean[][] charsUsed = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                chars[i][j] = matrix[i * cols + j];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (chars[i][j] == str[0]) {
                    boolean[] flag = new boolean[1];
                    charsUsed[i][j] = true;
                    dfs(chars, charsUsed, flag, 1, str, i, j);
                    charsUsed[i][j] = false;
                    if (flag[0]) return true;
                }
            }
        }
        return false;
    }

    private void dfs(char[][] chars, boolean[][] charsUsed, boolean[] flag, int index, char[] str, int i, int j) {
        if (index == str.length || flag[0]) {
            flag[0]=true;
            return;
        }
        for (int[] loc : getNears(i, j, chars.length, chars[0].length)) {
            if (!charsUsed[loc[0]][loc[1]] && chars[loc[0]][loc[1]] == str[index]) {
                charsUsed[loc[0]][loc[1]] = true;
                dfs(chars, charsUsed, flag, index + 1, str, loc[0], loc[1]);
                charsUsed[loc[0]][loc[1]] = false;
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
