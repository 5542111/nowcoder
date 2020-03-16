import com.sun.jmx.remote.internal.ArrayQueue;
import sun.awt.image.ImageWatched;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {

    Queue<Integer> queue=null;
    Deque<Integer> max=null;

    public MaxQueue() {
        queue=new LinkedList<>();
        max=new LinkedList<>();

    }

    public int max_value() {
        if (queue.isEmpty())
        {
            return -1;
        }
        return max.peekFirst();

    }

    public void push_back(int value) {

            while (!max.isEmpty()&&max.peekLast()<value)
            {
                max.pollLast();
            }
            max.addLast(value);
            queue.add(value);
    }

    public int pop_front() {
            if (queue.isEmpty()) return -1;
            int ans=queue.poll();
            if (max.peekFirst()==ans) max.pollFirst();

            return ans;
    }
}
