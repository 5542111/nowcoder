package doubleLeetWeek;

import java.util.HashSet;
import java.util.Set;

public class maxCount {
    public int maxCount(int[] banned, int n, int maxSum) {
            Set<Integer> banSet = new HashSet<>();
            for (int ban : banned) {
                banSet.add(ban);
            }
            int sum = 0;
            int count =0;
            for (int i = 1; i <= n; i++) {
                if (banSet.contains(i)) {
                    continue;
                }
                if (sum + i > maxSum) {
                    break;
                }

                sum += i;
                count++;
            }
            return count;
    }
}
