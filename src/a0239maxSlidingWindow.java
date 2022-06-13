import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class a0239maxSlidingWindow {
    public static void main(String[] args) {
        new a0239maxSlidingWindow().maxSlidingWindow2(new int[]{-6, -10, -7, -1, -9, 9, -8, -4, 10, -5, 2, 9, 0, -7, 7, 4, -2, -10, 8, 7}, 7);
    }

    /**
     * 单调栈
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> unRemovedIndex = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!unRemovedIndex.isEmpty() && nums[i] >= nums[unRemovedIndex.peekLast()]) {
                unRemovedIndex.pollLast();
            }
            unRemovedIndex.addLast(i);
        }
        int[] res = new int[n - k + 1];
        res[0] = nums[unRemovedIndex.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!unRemovedIndex.isEmpty() && nums[i] >= nums[unRemovedIndex.peekLast()]) {
                unRemovedIndex.pollLast();
            }
            unRemovedIndex.addLast(i);
            while (unRemovedIndex.peekFirst() <= i - k) {
                unRemovedIndex.pollFirst();
            }
            res[i - k + 1] = nums[unRemovedIndex.peekFirst()];
        }
        return res;
    }

    /**
     * 优先队列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];
            }
        });
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] res = new int[n - k + 1];
        res[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                System.out.println(pq.poll()[1]);
            }
            System.out.println();
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }
}
