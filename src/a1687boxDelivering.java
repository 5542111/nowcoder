import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class a1687boxDelivering {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        long preSum[] = new long[n + 1];
        int ans[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + boxes[i - 1][1];
            ans[i] = n * 10;
            int count = 0;
            for (int j = 1; j <= maxBoxes && j <= i; j++) {
                long w = preSum[i] - preSum[i - j];
                if (w > maxWeight) {
                    break;
                }
                if (j == 1 || (j != 1 && boxes[i - j][0] != boxes[i - j + 1][0])) {
                    count++;
                }
                ans[i] = Math.min(ans[i], ans[i - j] + count + 1);
            }
        }
        return ans[n];
    }

    public int boxDelivering2(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        long preSum1[] = new long[n + 1];
        int preSum2[] = new int[n + 5], ans[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum1[i] = preSum1[i - 1] + boxes[i - 1][1];
            preSum2[i] = preSum2[i - 1];
            if (i == 1 || (i > 1 && boxes[i - 1][0] != boxes[i - 2][0])) {
                preSum2[i]++;
            }
        }
        Queue<Integer> q = new PriorityQueue<>((a, b) -> ans[a] - preSum2[a + 1] - (ans[b] - preSum2[b + 1]));
        q.add(0);
        for (int i = 1; i <= n; i++) {
            while (true) {
                int a = q.peek();
                if (a < i - maxBoxes || maxWeight < preSum1[i] - preSum1[a]) {
                    q.poll();
                } else {
                    break;
                }
            }
            int b = q.peek();
            ans[i] = ans[b] + preSum2[i] - preSum2[b + 1] + 2;
            q.add(i);
        }
        return ans[n];
    }
    public int boxDelivering3(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n=boxes.length;
        long preSum1[]=new long[n+1];
        int preSum2[]=new int[n+5],ans[]=new int[n+1];
        for(int i=1;i<=n;i++){
            preSum1[i]=preSum1[i-1]+boxes[i-1][1];
            preSum2[i]=preSum2[i-1];
            if(i==1||(i>1&&boxes[i-1][0]!=boxes[i-2][0])){preSum2[i]++;}
        }
        Deque<Integer> q=new ArrayDeque<>();
        q.addLast(0);
        for(int i=1;i<=n;i++){
            while(true){
                int a=q.getFirst();
                if(a<i-maxBoxes||maxWeight<preSum1[i]-preSum1[a]){q.removeFirst();}
                else{break;}
            }
            int b=q.getFirst();
            ans[i]=ans[b]+preSum2[i]-preSum2[b+1]+2;
            while(q.size()>0){
                int a=q.getLast();
                if(ans[a]-preSum2[a+1]>=ans[i]-preSum2[i+1]){q.removeLast();}
                else{break;}
            }
            q.addLast(i);
        }
        return ans[n];
    }

}
