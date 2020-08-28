import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring48 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("asdedf"));
    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charAlphabet = new HashMap<>();
        int res = 0;
        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = charAlphabet.getOrDefault(s.charAt(i), -1);
            charAlphabet.put(s.charAt(i), i);
            tmp = tmp < i - j ? tmp + 1 : i - j;
            res = Math.max(res, tmp);
        }
        return res;
    }
}
