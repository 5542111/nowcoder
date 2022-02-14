import java.util.HashMap;
import java.util.Map;

public class a0242isAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashmap.put(s.charAt(i), hashmap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (hashmap.getOrDefault(t.charAt(i), 0) <= 0) {
                return false;
            } else {
                hashmap.put(t.charAt(i), hashmap.getOrDefault(t.charAt(i), 0) - 1);
            }
        }
        return true;
    }
}
