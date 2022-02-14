import java.util.HashMap;
import java.util.Map;

public class a0621leastInterval {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int maxExec = 0;
        for (char task : tasks) {
            int count = hashMap.getOrDefault(task, 0) + 1;
            hashMap.put(task, count);
            maxExec = Math.max(maxExec, count);
        }
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == maxExec) {
                maxCount++;
            }
        }
        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }
}
