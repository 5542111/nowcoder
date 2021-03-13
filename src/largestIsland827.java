import java.util.HashMap;
import java.util.Map;

public class largestIsland827 {
    HashMap<Integer,Integer> hm;
    int prev;

    public int largestIsland(int[][] grid) {
        hm=new HashMap<>();
        prev=0;
        int max=0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    prev++;
                    int a = dfs(grid, r, c);
                    max=Math.max(max,a);
                    hm.put(prev,a);

                }
            }
        }
        System.out.println(hm);
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    /**
                     获取4个点
                     */
                    int[] tmp=new int[4];
                    int temp=1;
                    if(r-1>=0&&grid[r-1][c]!=0){
                        tmp[0]=grid[r-1][c]-1;

                    }
                    if(r+1 < grid.length && grid[r+1][c]!=0){
                        tmp[1]=grid[r+1][c]-1;

                    }
                    if(c-1>=0&&grid[r][c-1]!=0){
                        tmp[2]=grid[r][c-1]-1;

                    }
                    if(c+1<grid[0].length&&grid[r][c+1]!=0){
                        tmp[3]=grid[r][c+1]-1;
                    }

                    HashMap<Integer,Integer> t=new HashMap<>();
                    for(int i:tmp){
                        t.put(i,hm.getOrDefault(i,0));
                    }
                    for(Map.Entry<Integer,Integer> entry:t.entrySet()){
                        temp+=entry.getValue();
                    }

                    max=Math.max(max,temp);
                }
            }
        }
        return max;

    }
    private int dfs(int[][] grid,int i,int j){
        if(!inArea(grid,i,j)){
            return 0;
        }
        if(grid[i][j]!= 1){
            return 0;
        }

        grid[i][j]=prev+1;


        return 1+dfs(grid,i-1,j)+  dfs(grid,i+1,j)+dfs(grid,i,j-1)+dfs(grid,i,j+1);
    }
    boolean inArea(int[][]grid,int r,int c){
        return r>=0&& r<grid.length&&c>=0&&c<grid[0].length;
    }
}
