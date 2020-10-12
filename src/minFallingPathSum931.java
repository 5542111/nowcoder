public class minFallingPathSum931 {
    public static void main(String[] args) {
        System.out.println(new minFallingPathSum931().minFallingPathSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
    }

    //典型dp
    public int minFallingPathSum(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[A.length + 1][A[0].length + 2];
        for (int i = 1; i < A.length + 1; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][A[0].length + 1] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < A[0].length + 1; j++) {
                dp[i][j] = A[i - 1][j - 1];
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < A[0].length + 1; j++) {
                dp[i][j] += Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i-1][j+1]));
                if (i==A.length)
                {
                    if (dp[i][j]<min)
                    {
                        min=dp[i][j];
                    }
                }
            }

        }
        return min;
    }
}
