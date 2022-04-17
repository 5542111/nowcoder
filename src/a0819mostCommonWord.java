import java.util.*;

public class a0819mostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        String s = paragraph.toLowerCase();
        String ans = null;
        Map<String, Integer> wordsCount = new HashMap<>();
        for (int i = 0; i < s.length(); ) {
            if (!Character.isLetter(s.charAt(i))) {
                ++i;
                continue;
            }
            int j = i;
            while (j < s.length() && Character.isLetter(s.charAt(j))) j++;
            String word = s.substring(i, j);
            i = j + 1;
            if (bannedSet.contains(word)) continue;
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
            if (ans == null || wordsCount.get(word) > wordsCount.get(ans)) ans = word;
        }
        return ans;
    }
}

