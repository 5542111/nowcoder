public class a0050myPow {
    public double myPow(double x, int n) {
        if (x == 0 && n == 0) return 1;
        if (n % 2 == 0 && x == -1) return 1;
        if (Math.abs(x) > 1 && (n == Integer.MIN_VALUE || n == Integer.MAX_VALUE)) return 0;
        return n >= 0 ? myPowHelper(x, n) : 1.0 / myPowHelper(x, -n);
    }

    private double myPowHelper(double x, int n) {
        double ans = 1;
        double temp = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= temp;
            }
            temp *= temp;
            n /= 2;
        }
        return ans;
    }
}
