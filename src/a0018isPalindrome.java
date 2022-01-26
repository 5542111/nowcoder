public class a0018isPalindrome {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c <= 'z' && c >= 'a') sb.append(c);
            if (c <= 'Z' && c >= 'A') sb.append(c);
            if (c <= '9' && c >= '0') sb.append(c);
        }
        if (sb.length() == 0) {
            return true;
        }
        return isPalindromeHelper(sb.toString().toLowerCase());

    }

    private boolean isPalindromeHelper(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }

}
