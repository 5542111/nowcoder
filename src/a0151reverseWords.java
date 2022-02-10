public class a0151reverseWords {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] strs = s.split(" ");
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].trim().length() != 0) {
                res.append(strs[i]).append(" ");
            }
        }
        return res.toString().trim();
    }

    public String reverseWords2(String s) {
        StringBuilder res = new StringBuilder();
        s = s.trim();
        int right = s.length() - 1;
        for (int i = right; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            for (int j = i; j >= 0; j--) {
                if (j == 0 || s.charAt(j) == ' ') {
                    if (j == 0) {
                        res.append(s.substring(j, i + 1));
                    } else if (s.charAt(j) == ' ') {
                        res.append(s.substring(j + 1, i + 1)).append(" ");
                    }
                    i = j;
                    break;
                }
            }
        }
        return res.toString();
    }

}
