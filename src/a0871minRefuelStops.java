import java.util.PriorityQueue;

public class a0871minRefuelStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] dp = new long[n + 1];
        dp[0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }

        for (int i = 0; i < n + 1; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }

        return -1;
    }


    public int minRefuelStops2(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int n = stations.length, index = 0;
        int leftFuel = startFuel, nowLoc = 0, res = 0;

        while (nowLoc < target) {
            if (leftFuel == 0) {
                if (!pq.isEmpty()) {
                    res++;
                    leftFuel += pq.poll();
                } else return -1;
            }
            nowLoc += leftFuel;
            leftFuel = 0;
            while (index < n && stations[index][0] <= nowLoc) pq.offer(stations[index++][1]);
        }
        return res;
    }
}
