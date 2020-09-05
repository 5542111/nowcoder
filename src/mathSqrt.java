public class mathSqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(2.0));
    }

    public static double sqrt(int a) {
        double x1 = 1, x2;
        x2 = x1 / 2.0 + a / (2 * x1);//牛顿迭代公式
        while (Math.abs(x2 - x1) > 1e-4) {
            x1 = x2;
            x2 = x1 / 2.0 + a / (2 * x1);
        }
        return x2;
    }

    public static double sqrt(double n) {
        if (n < 0) {
            return -1;
        } else if (n == 0 || n == 1) {
            return n;
        } else if (n > 0 && n < 1) {
            return sqrtHelper(n,n,1);
        }else {
            return sqrtHelper(n,1,n);
        }
    }

    public static double sqrtHelper(double n, double begin, double end) {
        double mid = (begin + end) / 2;
        while (end - begin > 0.0001) {
            if (mid * mid > n) {
                end = mid;
            } else {
                begin = mid;
            }
            mid = (begin + end) / 2;
        }
        return mid;
    }
}

