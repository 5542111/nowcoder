public class a1139largest1BorderedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] left = new int[row + 1][col + 1]; //表示当前节点左边有多少个连续1
        int[][] up = new int[row + 1][col + 1];  //表示当前节点上面有多少个连续1
        int maxBorder = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (grid[i - 1][j - 1] == 0) {
                    continue;
                }
                left[i][j] = left[i][j - 1] + 1;
                up[i][j] = up[i - 1][j] + 1;
                int border = Math.min(left[i][j], up[i][j]);
                while (left[i - border + 1][j] < border || up[i][j - border + 1] < border) {
                    border--;
                }
                maxBorder = Math.max(maxBorder, border);
            }
        }

        return maxBorder * maxBorder;
    }
}

