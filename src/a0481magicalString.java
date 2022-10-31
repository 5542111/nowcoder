public class a0481magicalString {

    public int magicalString(int n) {
        if (n <= 3) return 1;
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        sb.append("22");
        int index = 2;
        int now = 1;
        do {
            if (sb.charAt(index) == '1') {
                sb.append(now);
            } else {
                sb.append(now);
                sb.append(now);
            }
            now = (now & 1) == 1 ? 2 : 1;
            index++;
            if (sb.length() >= n) {
                break;
            }
        } while (index < sb.length());
        int count = 0;
        for (int i = 0; i < sb.length() && i < n; i++) {
            if (sb.charAt(i) == '1') count++;
        }
        return count;
    }

}
