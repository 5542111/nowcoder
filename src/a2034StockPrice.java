import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class a2034StockPrice {
    int currentTimeStamp;
    Map<Integer, Integer> stockPriceMap;
    PriorityQueue<int[]> pqMax;
    PriorityQueue<int[]> pqMin;

    public a2034StockPrice() {
        currentTimeStamp = 0;
        stockPriceMap = new HashMap<>();
        pqMax = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        pqMin = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
    }

    public void update(int timestamp, int price) {
        if (timestamp >= currentTimeStamp) {
            currentTimeStamp = timestamp;
        }
        stockPriceMap.put(timestamp, price);
        pqMax.add(new int[]{price, timestamp});
        pqMin.add(new int[]{price, timestamp});
    }

    public int current() {
        return stockPriceMap.get(currentTimeStamp);
    }

    public int maximum() {
        while (!pqMax.isEmpty()) {
            int[] temp = pqMax.peek();
            if (stockPriceMap.get(temp[1]) - temp[0] != 0) {
                pqMax.poll();
            } else {
                return temp[0];
            }
        }
        return -1;
    }

    public int minimum() {
        while (!pqMin.isEmpty()) {
            int[] temp = pqMin.peek();
            if (stockPriceMap.get(temp[1]) - temp[0] != 0) {
                pqMin.poll();
            } else {
                return temp[0];
            }
        }
        return -1;
    }
}
