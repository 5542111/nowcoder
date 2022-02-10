public class a0151reverseWords {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] strs = s.split(" ");
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].trim().length()!=0){
                res.append(strs[i]).append(" ");
            }
        }
        return res.toString().trim();
    }

}
