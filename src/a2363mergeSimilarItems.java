import java.util.*;

public class a2363mergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] ints : items1) {
            map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
        }
        for (int[] ints : items2) {
            map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        map.forEach((key, value) -> {
            List<Integer> temp = new ArrayList<>();
            temp.add(key);
            temp.add(value);
            res.add(temp);
        });
        res.sort(Comparator.comparingInt(o -> o.get(0)));
        return res;
    }
}
