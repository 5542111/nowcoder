import java.util.*;

public class a1761minTrioDegree {
    public int minTrioDegree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        for (int[] edge : edges) {
            Set<Integer> edgeList = edgeMap.getOrDefault(edge[0], new HashSet<>());
            edgeList.add(edge[1]);
            edgeMap.put(edge[0], edgeList);
            Set<Integer> edgeList2 = edgeMap.getOrDefault(edge[1], new HashSet<>());
            edgeList2.add(edge[0]);
            edgeMap.put(edge[1], edgeList2);
        }
        System.out.println(edgeMap);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (isTriple(edgeMap, i, j, k)) {
                        min = Math.min(min, edgeMap.get(i).size() + edgeMap.get(j).size() + edgeMap.get(k).size() - 6);
                    }
                }
            }
        }
        return min;
    }

    private boolean isTriple(Map<Integer, Set<Integer>> edgeMap, int i, int j, int k) {
        if (Objects.nonNull(edgeMap.get(i)) || Objects.nonNull(edgeMap.get(j)) || Objects.nonNull(edgeMap.get(k)))
            return false;
        return edgeMap.get(i).contains(j) && edgeMap.get(i).contains(k) && edgeMap.get(k).contains(j);
    }

}
