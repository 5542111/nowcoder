import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class a1331arrayRankTransform {
    public static void main(String[] args) {
        new a1331arrayRankTransform().arrayRankTransform(new int[]{40,10,20,30});
    }
    public int[] arrayRankTransform(int[] arr) {
        int[] clone = Arrays.copyOf(arr,arr.length);
        Arrays.sort(clone);

        Map<Integer, Integer> map = new HashMap<>();

        for (int j : clone) {
            if (map.get(j) == null) {
                map.put(j, map.size() + 1);
            }
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            res[i] =map.get(arr[i]);
        }
        return res;

    }
}
