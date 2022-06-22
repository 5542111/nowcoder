import java.util.*;

public class a1481findLeastNumOfUniqueInts {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (k == arr.length) return 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i : arr) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            pq.add(new int[]{entry.getValue(), entry.getKey()});
        }
        while (k > 0) {
            int[] poll = pq.poll();
            k -= poll[0];
        }
        int res =pq.size();
        if (k < 0) {
            res+=1;
        }
        return res;
    }
}
