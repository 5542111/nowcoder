public class o1724getMaxMatrix {
    public static void main(String[] args) {
        new o1724getMaxMatrix().getMaxMatrix(new int[][]{{1, 2, 3, 4}, {1, 2, 3, 4}});
    }

    public int[] getMaxMatrix(int[][] matrix) {
        int[] res = new int[4];
        int row = matrix.length;
        int col = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;
        int[][] preNum = new int[row + 1][col + 1];

        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                preNum[i][j] = preNum[i - 1][j] + preNum[i][j - 1] + matrix[i - 1][j - 1] - preNum[i - 1][j - 1];
            }
        }

        for (int top = 0; top < row; top++) {
            for (int bottom = top; bottom < row; bottom++) {
                int tempMax = 0, left = 0;
                for (int right = 0; right < col; right++) {
                    tempMax = preNum[bottom + 1][right + 1] + preNum[top][left] - preNum[bottom + 1][left] - preNum[top][right + 1];
                    if (maxSum < tempMax) {
                        maxSum = tempMax;
                        res[0] = top;
                        res[1] = left;
                        res[2] = bottom;
                        res[3] = right;
                    }
                    if (tempMax < 0) {
                        left = right + 1;
                    }
                }
            }
        }
        return res;
    }
}
