

public class closedIsland1254 {
    public static void main(String[] args) {
        System.out.println(new closedIsland1254().closedIsland(new int[][]{
                {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}
        }));
    }


    public int closedIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        if (grid[0].length == 0) {
            return 0;
        }
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {

                    if (dfs(grid, i, j)) {
                        res++;
                        System.out.println(i+" "+j+":"+res);
                    }


                }
            }
        }
        return res;

    }

    private boolean dfs(int[][] grid,int i ,int j){
        int rows = grid.length;
        int cols = grid[0].length;
        if(i < 0 || j < 0 || i >=rows || j >= cols){
            return false;
        }
        if(grid[i][j] == 1){
            return true;
        }
        grid[i][j] = 1;
        boolean up = dfs(grid,i-1,j);
        boolean down = dfs(grid,i+1,j);
        boolean left = dfs(grid,i,j-1);
        boolean right = dfs(grid,i,j+1);
        if(up && down && left && right){
            return true;
        }
        return false;
    }


}
