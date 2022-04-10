import java.util.HashSet;
import java.util.Set;

public class a0804uniqueMorseRepresentations {

    public int uniqueMorseRepresentations(String[] words) {
        String[] morseMap = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> hs = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(morseMap[word.charAt(i) - 'a']);
            }
            hs.add(sb.toString());
        }
        return hs.size();
    }
}
