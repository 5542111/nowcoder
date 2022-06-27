import java.util.*;

public class checkCycledDependency {
    public List<Integer> solution(int[][] edges, int n) {
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        int[] inDegreeCount = new int[n];
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0], to = edges[i][1];
            inDegreeCount[to]++;
            List<Integer> toList = edgeMap.getOrDefault(from, new ArrayList<>());
            toList.add(to);
            edgeMap.put(from, toList);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegreeCount[i] == 0)
                queue.offerLast(i);
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer key = queue.pollFirst();
            res.add(key);
            List<Integer> integers = edgeMap.getOrDefault(key,new ArrayList<>());
            for (Integer integer : integers) {
                inDegreeCount[integer]--;
                if (inDegreeCount[integer] == 0) {
                    queue.offerLast(integer);
                }
            }
        }
        if (res.size() == n) return res;
        return new ArrayList<>();
    }
}
