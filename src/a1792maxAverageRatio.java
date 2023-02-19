import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class a1792maxAverageRatio {

    public double maxAverageRatio(int[][] classes, int extraStudents) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            long v1 = (long) (o2[1] + 1) * o2[1] * (o1[1] - o1[0]);
            long v2 = (long) (o1[1] + 1) * o1[1] * (o2[1] - o2[0]);
            if (v2 == v1) return 0;
            return v1 < v2 ? 1 : -1;
        });
        pq.addAll(Arrays.asList(classes));

        for (int i = 0; i < extraStudents; i++) {
            int[] arr = pq.poll();
            int pass = arr[0], total = arr[1];
            pq.offer(new int[]{pass + 1, total + 1});
        }

        double ans = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            ans += 1.0 * poll[0] / poll[1];
        }
        return ans / classes.length;

    }
}
