import java.util.ArrayList;
import java.util.List;

public class a0745WordFilter {
    String[] res;

    public a0745WordFilter(String[] words) {
        res = words;
    }

    public int f(String pref, String suff) {
        for (int i = res.length - 1; i >= 0; i--) {
            String re = res[i];
            if (pref.length() > re.length() || suff.length() > re.length()) continue;
            boolean flag = true;
            for (int j = 0; j < pref.length(); j++) {
                if (re.charAt(j) != pref.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            for (int j = 0; j < suff.length(); j++) {
                if (re.charAt(re.length() - 1 - j) != suff.charAt(suff.length() - 1 - j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return -1;
    }
}

class WordFilter {

    TrieNode tr1 = new TrieNode(), tr2 = new TrieNode();

    class TrieNode {
        TrieNode[] tns = new TrieNode[26];
        List<Integer> indices = new ArrayList<>();
    }

    void add(TrieNode p, String str, int index, boolean isTurn) {
        int n = str.length();
        p.indices.add(index);
        for (int i = isTurn ? n - 1 : 0; i < n && i >= 0; i += isTurn ? -1 : 1) {
            int now = str.charAt(i) - 'a';
            if (p.tns[now] == null) {
                p.tns[now] = new TrieNode();
            }
            p = p.tns[now];
            p.indices.add(index);
        }
    }

    int query(String prefix, String suffix) {
        TrieNode p = tr1;
        for (int i = 0; i < prefix.length(); i++) {
            int now = prefix.charAt(i) - 'a';
            if (p.tns[now] == null) return -1;
            p = p.tns[now];
        }
        List<Integer> prefixList = p.indices;

        p = tr2;

        for (int i = suffix.length() - 1; i >= 0; i--) {
            int now = suffix.charAt(i) - 'a';
            if (p.tns[now] == null) return -1;
            p = p.tns[now];
        }
        List<Integer> suffixList = p.indices;
        for (int i = prefixList.size() - 1, j = suffixList.size() - 1; i >= 0 && j >= 0; ) {
            if (prefixList.get(i) > suffixList.get(j)) i--;
            else if (prefixList.get(i) < suffixList.get(j)) j--;
            else return prefixList.get(i);
        }
        return -1;
    }

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            add(tr1, words[i], i, false);
            add(tr2, words[i], i, true);
        }
    }

    public int f(String prefix, String suffix) {
        return query(prefix, suffix);
    }
}