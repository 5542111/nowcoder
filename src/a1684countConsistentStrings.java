public class a1684countConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        int[] count = new int[26];
        for (char c : allowed.toCharArray()) {
            count[c-'a'] += 1;
        }
        int res = 0;
        for (String word : words) {
            boolean flag = false;
            for (char c : word.toCharArray()) {
                if (count[c-'a']==0){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                res++;
            }
        }
        return res;
    }
}
