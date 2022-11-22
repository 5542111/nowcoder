public class a0878nthMagicalNumber {
    public int nthMagicalNumber(int n, int a, int b) {
        int MOD = 1000000007;
        long l = Math.min(a, b);
        long r = l * n;

        int c = lcm(a, b);

        while (l < r) {
            long mid = (l + r) / 2;
            long cnt = mid / a + mid / b - mid / c;
            if (cnt >= n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ((r + 1) % MOD);
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }


    public int nthMagicalNumber2(int n, int a, int b) {
        int MOD = 1000000007;
        int c = lcm(a, b);
        int mid = c / a + c / b - 1;
        int right = n % mid;
        int res = (int) ((long) c * (n / mid) % MOD);
        if (right == 0) return res;

        int addA = a;
        int addB = b;
        for (int i = 0; i < right - 1; i++) {
            if (addA < addB) addA += a;
            else addB += b;
        }

        return (res + Math.min(addA, addB) % MOD) % MOD;
    }
}
