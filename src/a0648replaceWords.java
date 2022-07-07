import java.util.*;

public class a0648replaceWords {
    public static void main(String[] args) {
        System.out.println(new a0648replaceWords().replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dictionarySet = new HashSet<>(dictionary);
        String[] split = sentence.split(" ");
        StringJoiner sj = new StringJoiner(" ");
        for (String word : split) {
            boolean flag = true;
            for (int j = 0; j < word.length(); j++) {
                if (dictionarySet.contains(word.substring(0, 1 + j))) {
                    sj.add(word.substring(0, 1 + j));
                    flag = false;
                    break;
                }
            }
            if (flag) sj.add(word);

        }

        return sj.toString();
    }

    public String replaceWords2(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            Trie cur = trie;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
            }
            cur.children.put('#', new Trie());
        }
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            split[i] = findRoot(split[i], trie);
        }
        return String.join(" ", split);
    }

    private String findRoot(String word, Trie trie) {
        StringBuilder root = new StringBuilder();
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.get('#') != null) {
                return root.toString();
            }
            if (!cur.children.containsKey(c)) {
                return word;
            }
            root.append(c);
            cur = cur.children.get(c);
        }
        return root.toString();
    }
}

class Trie {
    Map<Character, Trie> children;

    public Trie() {
        children = new HashMap<>();
    }
}