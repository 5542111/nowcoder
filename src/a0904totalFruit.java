import java.util.HashMap;
import java.util.Map;

public class a0904totalFruit {

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> hm = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < fruits.length) {
            hm.put(fruits[right], hm.getOrDefault(fruits[right], 0) + 1);
            while (hm.size() > 2) {
                hm.put(fruits[left], hm.get(fruits[left]) - 1);
                if (hm.get(fruits[left]) == 0) {
                    hm.remove(fruits[left]);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}
