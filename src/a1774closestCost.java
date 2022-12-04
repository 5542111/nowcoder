import java.util.*;

public class a1774closestCost {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int min = Arrays.stream(baseCosts).min().orElse(0);
        if (min >= target) {
            return min;
        }
        boolean[] canMake = new boolean[target + 1];
        int res = 2 * target - min;
        for (int baseCost : baseCosts) {
            if (baseCost <= target) {
                canMake[baseCost] = true;
            } else {
                res = Math.min(res, baseCost);
            }
        }
        for (int t : toppingCosts) {
            for (int count = 0; count < 2; ++count) {
                for (int i = target; i > 0; --i) {
                    if (canMake[i] && i + t > target) {
                        res = Math.min(res, i + t);
                    }
                    if (i - t > 0) {
                        canMake[i] = canMake[i] | canMake[i - t];
                    }
                }
            }
        }

        for (int i = 0; i <= res - target; i++) {
            if (canMake[target - i]) {
                return target - i;
            }
        }
        return res;
    }
}
