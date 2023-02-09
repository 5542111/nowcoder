import java.util.HashMap;
import java.util.Map;

public class a0397integerReplacement {
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if ((n & 1) == 0) {
            return 1 + integerReplacement(n / 2);
        }
        return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
    }

    Map<Integer, Integer> memo = new HashMap<>();

    public int integerReplacement2(int n) {
        if (n == 1) {
            return 0;
        }
        if (!memo.containsKey(n)) {
            if ((n & 1) == 0) {
                memo.put(n, integerReplacement2(n / 2) + 1);
            } else {
                memo.put(n, Math.min(integerReplacement2(n / 2), integerReplacement2(n / 2 + 1)) + 2);
            }
        }
        return memo.get(n);
    }

    public int integerReplacement3(int n) {
        int ans = 0;
        while (n > 1) {
            if ((n & 1) == 0) {
                ans++;
                n /= 2;
            } else {
                if (n % 4 == 1) {
                    n /= 2;
                } else {
                    if (n == 3) {
                        n = 1;
                    } else {
                        n = n / 2 + 1;
                    }
                }
                ans += 2;
            }
        }
        return ans;
    }
}

