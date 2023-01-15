public class a1837sumBase {
    public int sumBase(int n, int k) {
        if (k == 10) {
            return totalSum(String.valueOf(n));
        }
        StringBuilder sb = new StringBuilder();
        while (n >= k) {
            int temp = n % k;
            n /= k;
            sb.append(temp);
        }
        sb.append(n);
        return totalSum(sb.reverse().toString());

    }


    private int totalSum(String num) {
        int sum = 0;
        for (char c : num.toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }
}
