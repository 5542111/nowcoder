
import java.util.*;

public class a0895FreqStack {
    private Map<Integer, Integer> freqMap;
    private Map<Integer, Deque<Integer>> freqGroupMap;
    private int maxFreq;

    public a0895FreqStack() {
        freqMap = new HashMap<>();
        freqGroupMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        freqGroupMap.putIfAbsent(freqMap.get(val), new ArrayDeque<>());
        freqGroupMap.get(freqMap.get(val)).push(val);
        maxFreq = Math.max(maxFreq, freqMap.get(val));
    }

    public int pop() {
        int val = freqGroupMap.get(maxFreq).peek();
        freqMap.put(val, freqMap.get(val) - 1);
        freqGroupMap.get(maxFreq).pop();
        if (freqGroupMap.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        return val;
    }
}
