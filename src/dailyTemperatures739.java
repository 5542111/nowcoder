import java.util.Deque;
import java.util.LinkedList;

public class dailyTemperatures739 {
    public int[] dailyTemperatures(int[] T) {
        int[] res=new int[T.length];
        Deque<Integer> deque=new LinkedList<>();
        for (int i = 0; i <T.length ; i++) {
            int temp=T[i];
            while(!deque.isEmpty() && temp>T[deque.peekLast()] ){
                int preIndex=deque.pollLast();
                res[preIndex]=i-preIndex;
            }
            deque.add(i);
        }

        return res;
    }
}
