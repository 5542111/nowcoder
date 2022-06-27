import java.util.*;

public class a0207canFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        int[] inDegreeCount = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0], to = prerequisites[i][1];
            inDegreeCount[to]++;
            List<Integer> toList = edgeMap.getOrDefault(from, new ArrayList<>());
            toList.add(to);
            edgeMap.put(from, toList);
        }
        System.out.println(edgeMap);
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
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
        if (res.size() == numCourses) return true;
        return false;
    }
}
