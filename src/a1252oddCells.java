import java.util.HashMap;
import java.util.Map;

public class a1252oddCells {

    public int oddCells(int m, int n, int[][] indices) {
        int[][] res = new int[m][n];
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        for (int[] index : indices) {
            rowMap.put(index[0], rowMap.getOrDefault(index[0], 0) + 1);
            colMap.put(index[1], colMap.getOrDefault(index[1], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : rowMap.entrySet()) {
            for (int i = 0; i < n; i++) {
                res[entry.getKey()][i] += entry.getValue();
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : colMap.entrySet()) {
            for (int i = 0; i < m; i++) {
                res[i][entry.getKey()] += entry.getValue();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((res[i][j] & 1) == 1) ans++;
            }
        }

        return ans;
    }

    public int oddCells2(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;

        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (((rows[i] + cols[j]) & 1) != 0) ans++;
            }

        }

        return ans;
    }

    public int oddCells3(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;

        }
        int oddX = 0, oddY = 0;
        for (int i = 0; i < m; i++) {
            if ((rows[i] & 1) != 0) oddX++;

        }
        for (int j = 0; j < n; j++) {
            if ((cols[j] & 1) != 0) oddY++;
        }

        return oddX * (n - oddY) + oddY * (m - oddX);
    }
}
