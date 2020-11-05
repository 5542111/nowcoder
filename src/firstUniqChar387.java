public class firstUniqChar387 {
    public int firstUniqChar(String s) {
        if (s==null||s.length()==0)
        {
            return -1;
        }
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < chars.length; i++) {
            count[chars[i] - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
