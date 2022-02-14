import java.util.HashMap;
import java.util.Map;

public class a0447numberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        if (points.length < 3) return 0;
        for (int[] x : points) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int[] y : points) {
                if (x == y) continue;
                int distance = (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]);
                cnt.put(distance, cnt.getOrDefault(distance, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }
}
