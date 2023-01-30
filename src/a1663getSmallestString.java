public class a1663getSmallestString {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int lower = Math.max(1, k - (n - i) * 26);
            k -= lower;
            sb.append((char) ('a' + lower - 1));
        }
        return sb.toString();
    }
}
