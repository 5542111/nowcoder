import java.util.ArrayList;
import java.util.List;

public class spiralOrder54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        boolean[][] matrixUsed=new boolean[matrix.length][matrix[0].length];
        int x=0,y=0;
        int[] dx={-1,0,1,0},dy={0,1,0,-1};
        int d=1;
        for (int i = 0; i <matrix.length*matrix[0].length ; i++) {
            res.add(matrix[x][y]);
            matrixUsed[x][y]=true;
            int a=x+dx[d],b=y+dy[d];
            if (a<0||a>=matrix.length||b<0||b>=matrix[0].length||matrixUsed[a][b]){
                d=(d+1)%4;
                a=x+dx[d];
                b=y+dy[d];
            }
            x=a;
            y=b;
        }
        return res;

    }
}
