import java.util.*;

public class a1233removeSubfolders {
    //排序暴力解决
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            int pre = ans.get(ans.size() - 1).length();
            if (!(pre < folder[i].length() && ans.get(ans.size() - 1).equals(folder[i].substring(0, pre)) && folder[i].charAt(pre) == '/')) {
                ans.add(folder[i]);
            }
        }
        return ans;
    }

    public List<String> removeSubfolders2(String[] folder) {
        Trie root = new Trie();
        for (int i = 0; i < folder.length; i++) {
            List<String> path = splitFolder(folder[i]);
            Trie cur = root;
            for (String str : path) {
                cur.children.putIfAbsent(str, new Trie());
                cur = cur.children.get(str);
            }
            cur.ref = i;
        }
        List<String> ans = new ArrayList<>();
        dfs(root, ans, folder);
        return ans;

    }

    private List<String> splitFolder(String folder) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < folder.length(); i++) {
            char c = folder.charAt(i);
            if (c == '/') {
                ans.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        ans.add(sb.toString());
        return ans;
    }

    private void dfs(Trie root, List<String> ans, String[] folder) {
        if (root.ref != -1) {
            ans.add(folder[root.ref]);
        } else {
            for (Trie child : root.children.values()) {
                dfs(child, ans, folder);
            }
        }
    }

    static class Trie {
        int ref;
        Map<String, Trie> children;

        public Trie() {
            this.ref = -1;
            this.children = new HashMap<>();
        }

        public Trie(int ref, Map<String, Trie> children) {
            this.ref = ref;
            this.children = children;
        }


    }

}

