public class a0357countNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int temp = 9, res = 10;
        for (int i = 0; i < n - 1; i++) {
            temp *= 9 - i;
            res += temp;
        }
        return res;
    }
}
