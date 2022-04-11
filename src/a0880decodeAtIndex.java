public class a0880decodeAtIndex {
    public String decodeAtIndex(String s, int k) {
        long preLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                preLen *= c - '0';
            } else {
                preLen++;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= preLen;
            if (k == 0 && Character.isLetter(c)) {
                return String.valueOf(c);
            }
            if (Character.isDigit(c)) {
                preLen /= c - '0';
            } else {
                preLen--;
            }
        }

        return "";
    }
}

