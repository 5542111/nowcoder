public class a0883projectionArea {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        //先统计 先统计俯视图
        int top = 0;
        int front = 0;
        int side = 0;

        for (int i = 0; i < n; i++) {
            int sideSingleMax = 0;
            int frontSingleMax = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) top++;
                frontSingleMax = Math.max(frontSingleMax, grid[i][j]);
                sideSingleMax = Math.max(sideSingleMax, grid[j][i]);
            }
            front += frontSingleMax;
            side += sideSingleMax;

        }
        System.out.println(top + " " + front + " " + side);
        return top + front + side;
    }
}
