import java.util.HashMap;
import java.util.Map;

public class a2131longestPalindrome {
    public int longestPalindrome(String[] words) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> palindromeMap = new HashMap<>();
        for (String word : words) {
            if (word.charAt(0) == word.charAt(1)) {
                palindromeMap.put(word, palindromeMap.getOrDefault(word, 0) + 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        for (String str : map.keySet()) {
            String temp = String.valueOf(str.charAt(1)) + str.charAt(0);
            res += 2 * Math.min(map.getOrDefault(temp, 0), map.get(str));
        }
        //中心词 max 如果有奇数个的情况 就存在中心词
        int max = 0;
        for (Map.Entry<String, Integer> entry : palindromeMap.entrySet()) {
            if (entry.getValue() == 1) {
                max = Math.max(max, 2);
            } else {
                if ((entry.getValue() & 1) == 1) {
                    res += (entry.getValue() - 1) * 2;
                    max = Math.max(max, 2);
                } else {
                    res += entry.getValue() * 2;
                }
            }
        }
        return res + max;
    }

}
