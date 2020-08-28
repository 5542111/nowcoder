import com.sun.org.apache.regexp.internal.RE;

import java.util.Scanner;

public class cutRope67 {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        new cutRope67().cutRope(n);

    }

    public int cutRope(int n) {

        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            return 4 * (int) Math.pow(3, n / 3 - 1);
        } else {
            return 2 * (int) Math.pow(3, n / 3);
        }

    }

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] arr=new boolean[rows][cols];
        return movingCount(threshold,0,0,rows,cols,arr);
    }
    public int movingCount(int threshold, int curR,int curC, int rows, int cols,boolean [][] isState) {
        int res = 0;
        if(!isState[curR][curC] && isMoving(threshold,curR,curC)){
            res += 1;
            isState[curR][curC]=true;
            res += (curR - 1 >= 0 && !isState[curR-1][curC] && isMoving(threshold,curR-1,curC)? movingCount(threshold,curR-1,curC,rows,cols,isState):0);
            res += (curR + 1 < rows && !isState[curR+1][curC] && isMoving(threshold,curR+1,curC)? movingCount(threshold,curR+1,curC,rows,cols,isState):0);
            res += (curC - 1 >= 0 && !isState[curR][curC-1] && isMoving(threshold,curR,curC-1)? movingCount(threshold,curR,curC-1,rows,cols,isState):0);
            res += (curC + 1 < cols && !isState[curR][curC+1] && isMoving(threshold,curR,curC+1)? movingCount(threshold,curR,curC+1,rows,cols,isState):0);
        }



        return res;
    }

    private boolean isMoving(int threshold,int i,int j) {
        int val = 0;
        while(i!=0){
            val += i%10;
            i /= 10;
        }
        while(j!=0){
            val += j%10;
            j /= 10;
        }

        return val<=threshold;
    }
}
