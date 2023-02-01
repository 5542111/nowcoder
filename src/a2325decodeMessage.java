import java.util.HashMap;
import java.util.Map;

public class a2325decodeMessage {
    public static void main(String[] args) {
        System.out.println(new a2325decodeMessage().decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }

    public String decodeMessage(String key, String message) {
        Map<Character, Character> letterMap = new HashMap<>();

        int index = 0;
        for (char c : key.toCharArray()) {
            if (c == ' ') continue;
            Character ch = letterMap.get(c);
            if (ch == null) {
                letterMap.put(c,(char) ('a' + index));
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') sb.append(c);
            else sb.append(letterMap.get(c));
        }
        return sb.toString();
    }

}
