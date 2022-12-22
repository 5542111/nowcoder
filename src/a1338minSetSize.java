import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a1338minSetSize {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        list.sort((o1, o2) -> o2 - o1);
        int halfCount = arr.length  / 2 ;
        int res = 0;
        int total = 0;
        for (int count : list) {
            res += 1;
            total += count;
            if (total > halfCount) {
                break;
            }
        }
        return res;
    }
}
