public class a0443compress {


    public int compress(char[] chars) {
        if (chars.length <= 1) return chars.length;
        int n = chars.length;
        char ch = chars[0];
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        while (right < n) {
            sb.append(ch);
            while (right < n && chars[right] == ch) {
                right++;
            }
            if (right == left) {
                left = right;
                ch = chars[left];
            } else {
                if (right - left > 1) sb.append(right - left);
                left = right;
                if (right < n) {
                    ch = chars[left];
                }
            }
        }
        for (int i = 0; i < sb.length() && i < n; i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}

