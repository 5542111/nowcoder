import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    Map<Integer, FreqNode> cache;  // 存储缓存的内容
    Map<Integer, LinkedHashSet<FreqNode>> freqMap; // 存储每个频次对应的双向链表
    int size;
    int capacity;
    int min; // 存储当前最小频次

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        FreqNode freqNode = cache.get(key);
        if (freqNode == null) {
            return -1;
        }
        freqInc(freqNode);
        return freqNode.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        FreqNode freqNode = cache.get(key);
        if (freqNode != null) {
            freqNode.value = value;
            freqInc(freqNode);
        } else {
            if (size == capacity) {
                FreqNode deadFreqNode = removeNode();
                cache.remove(deadFreqNode.key);
                size--;
            }
            FreqNode newFreqNode = new FreqNode(key, value);
            cache.put(key, newFreqNode);
            addNode(newFreqNode);
            size++;
        }
    }

    private void freqInc(FreqNode freqNode) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = freqNode.freq;
        LinkedHashSet<FreqNode> set = freqMap.get(freq);
        set.remove(freqNode);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        freqNode.freq++;
        LinkedHashSet<FreqNode> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(freqNode);
    }

    private void addNode(FreqNode freqNode) {
        LinkedHashSet<FreqNode> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(freqNode);
        min = 1;
    }

    private FreqNode removeNode() {
        LinkedHashSet<FreqNode> set = freqMap.get(min);
        FreqNode deadFreqNode = set.iterator().next();
        set.remove(deadFreqNode);
        return deadFreqNode;
    }
}

class FreqNode {
    int key;
    int value;
    int freq = 1;

    public FreqNode() {}

    public FreqNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
