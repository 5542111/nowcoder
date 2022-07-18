import java.util.LinkedList;
import java.util.Queue;

public class o0041MovingAverage {
    Queue<Integer> queue = new LinkedList<>();
    int size = 0;
    double total = 0;

    public o0041MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() >= size) {
            Integer poll = queue.poll();
            total -= poll;
        }
        total += val;
        queue.offer(val);
        return total  / queue.size();
    }
}
