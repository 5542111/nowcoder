import java.util.PriorityQueue;

public class greedy {
    public static void main(String[] args) {
        System.out.println(combination(new int[]{1, 2, 9}));
    }
    public static int combination(int[] arr) {

//        Comparator<Integer> comparator=new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        };
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (Integer integer : arr) {
            priorityQueue.add(integer);
        }
        int sum = 0;
        while (priorityQueue.size() > 1) {
            int temp = priorityQueue.poll() + priorityQueue.poll();
            sum += temp;
            priorityQueue.add(temp);
        }
        //sum+=priorityQueue.poll();
        return sum;
    }
}
