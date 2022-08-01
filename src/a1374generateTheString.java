public class a1374generateTheString {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if ((n & 1) == 0) {
            while (n-- > 1) {
                sb.append('a');
                n--;
            }
            sb.append('b');
        } else {
            while (n-- > 0) {
                sb.append('a');
            }
        }
        return sb.toString();
    }
}
