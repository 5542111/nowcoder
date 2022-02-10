public class a0240searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int j = 0;
        while (j < n && m > 0) {
            if (matrix[m - 1][j] > target) {
                m--;
            } else if (matrix[m - 1][j] < target) {
                j++;
            } else {
                return true;
            }
        }

        return false;
    }
}
