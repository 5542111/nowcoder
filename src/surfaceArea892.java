public class surfaceArea892 {
    public int surfaceArea(int[][] grid) {
        int num = 0;
        int repeat = 0;
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                int cur = grid[i][j];
                num += cur;

                //三维考虑 上 下两个方向的重叠
                if (cur > 1) {
                    repeat += cur - 1;
                }
                //三维考虑  里 左 两个方向的重叠   外 右会被计算到表面积中
                if (cur > 0) {
                    //里
                    if (i > 0 &&grid[i-1][j]>0)
                    {
                        repeat+=Math.min(cur,grid[i-1][j]);
                    }
                    //左
                    if (j > 0 &&grid[i][j-1]>0)
                    {
                        repeat+=Math.min(cur,grid[i][j-1]);
                    }
                }
            }

        }
        return num*6-repeat*2;
    }
}
