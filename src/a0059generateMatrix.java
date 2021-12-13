import java.util.ArrayList;
import java.util.List;

public class a0059generateMatrix {
    public static void main(String[] args) {
        generateMatrix(3);
    }

    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        boolean[][] matrixUsed = new boolean[n][n];
        int x=0,y=0;
        int[] dx={-1,0,1,0},dy={0,1,0,-1};
        int d=1;
        for (int i = 0; i <n*n ; i++) {
            ans[x][y]=i+1;
            matrixUsed[x][y]=true;
            int a=x+dx[d],b=y+dy[d];
            if (a<0||a>=n||b<0||b>=n||matrixUsed[a][b]){
                d=(d+1)%4;
                a=x+dx[d];
                b=y+dy[d];
            }
            x=a;
            y=b;
        }
        return ans;

    }
}
