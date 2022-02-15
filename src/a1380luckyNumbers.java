import java.util.ArrayList;
import java.util.List;

public class a1380luckyNumbers {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[] minRow = new int[matrix.length];
        int[] maxCol = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            minRow[i] = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                minRow[i] = Math.min(matrix[i][j], minRow[i]);
                maxCol[j] = Math.max(matrix[i][j], maxCol[j]);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (minRow[i] == matrix[i][j] && maxCol[j] == matrix[i][j]) res.add(minRow[i]);
            }
        }
        return res;
    }

}
