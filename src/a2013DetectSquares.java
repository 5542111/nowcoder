import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class a2013DetectSquares {
    Map<Integer, Map<Integer, Integer>> cnt;

    public a2013DetectSquares() {
        cnt = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        cnt.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> map = cnt.get(x);
        map.put(y, map.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0;
        int x = point[0], y = point[1];
        if (!cnt.containsKey(x)) {
            return 0;
        }
        Map<Integer, Integer> xCnt = cnt.get(x);
        Set<Map.Entry<Integer, Map<Integer, Integer>>> entries = cnt.entrySet();
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : entries) {
            int row = entry.getKey();
            Map<Integer, Integer> rowCnt = entry.getValue();
            if (row != x) {
                int d = row - x;
                res += rowCnt.getOrDefault(y, 0) * xCnt.getOrDefault(y + d, 0) * rowCnt.getOrDefault(y + d, 0);
                res += rowCnt.getOrDefault(y, 0) * xCnt.getOrDefault(y - d, 0) * rowCnt.getOrDefault(y - d, 0);

            }
        }
        return res;
    }
}
