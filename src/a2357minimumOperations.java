import java.util.PriorityQueue;

public class a2357minimumOperations {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        int count = 0;
        int res = 0;
        while (!pq.isEmpty()) {
            int poll = pq.poll();
            if (poll > count) {
                count += (poll - count);
                res++;
            }


        }
        return res;
    }
}
