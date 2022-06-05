import java.util.*;

public class a1519countSubTrees {
    public static void main(String[] args) {
        new a1519countSubTrees().countSubTrees(7, new int[][]
                {
                        {0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}
                }, "abaedcd");
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> treeMap = new HashMap<>();
        for (int[] edge : edges) {
            int father = edge[0], son = edge[1];
            List<Integer> points0 = treeMap.getOrDefault(father, new ArrayList<>());
            List<Integer> points1 = treeMap.getOrDefault(son, new ArrayList<>());
            points0.add(son);
            points1.add(father);
            treeMap.put(father, points0);
            treeMap.put(son, points1);
        }
        System.out.println(treeMap);
        int[] counts = new int[n];
        dfs(0, treeMap, new boolean[n], counts, labels);
        return counts;

    }

    private int[] dfs(int key, Map<Integer, List<Integer>> treeMap, boolean[] visited, int[] counts, String labels) {
        visited[key] = true;
        int[] curCounts = new int[26];
        curCounts[labels.charAt(key) - 'a']++;
        List<Integer> nodeList = treeMap.get(key);
        for (Integer node : nodeList) {
            if (!visited[node]) {
                int[] childCounts = dfs(node, treeMap, visited, counts, labels);
                for (int i = 0; i < 26; i++) {
                    curCounts[i] += childCounts[i];
                }
            }
        }
        counts[key] = curCounts[labels.charAt(key) - 'a'];
        return curCounts;
    }
}
