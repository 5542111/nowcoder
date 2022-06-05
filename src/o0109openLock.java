import java.util.*;

public class o0109openLock {
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) return 0;
        boolean[] visited = new boolean[10000];
        Set<Integer> deadSet = new HashSet<>();
        for (String deadend : deadends) {
            deadSet.add(Integer.parseInt(deadend));
        }
        if (deadSet.contains(0)) return -1;
        int tgt = Integer.parseInt(target);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int id = current[0], len = current[1];
            if (id < 0 || len >= 10000 || visited[id] || deadSet.contains(id)) continue;
            if (id == tgt) return len;

            visited[id] = true;
            int index = 1;
            for (int i = 0; i < 4; i++) {
                int temp = id / index % 10;

                if (temp == 0) {
                    queue.add(new int[]{id + 9 * index, len + 1});
                } else {
                    queue.add(new int[]{id - index, len + 1});
                }

                if (temp == 9) {
                    queue.add(new int[]{id - 9 * index, len + 1});
                } else {
                    queue.add(new int[]{id + index, len + 1});
                }
                index *= 10;
            }
        }
        return -1;
    }


}
