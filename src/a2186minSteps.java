public class a2186minSteps {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += Math.abs(count[i]);
        }
        return res;
    }
}
