import java.util.*;

public class a0316removeDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(new a0316removeDuplicateLetters().removeDuplicateLetters("mitnlruhznjfyzmtmfnstsxwktxlboxutbic"));
    }

    public String removeDuplicateLetters(String s) {
        int len = s.length();
        int[] count = new int[26];
        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'a']++;
        }
        boolean[] visited = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a']--;
            if (visited[c - 'a']) continue;
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek() - 'a'] == 0) {
                    break;
                }
                char pop = stack.pop();
                visited[pop - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }


    //dfs 暴力解法 复杂度高了
    private List<String> list;
    int count = 0;

    public String removeDuplicateLetters2(String s) {
        int length = s.length();
        list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        count = set.size();
        dfs(s.toCharArray(), 0, new StringBuilder(), new HashSet<>());
        System.out.println(list);

        Collections.sort(list);

        return list.get(0);
    }

    private void dfs(char[] chars, int index, StringBuilder sb, Set<Character> set) {
        if (set.size() == count) {
            list.add(sb.toString());
        }
        for (int i = index; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                sb.append(chars[i]);
                set.add(chars[i]);
                dfs(chars, i + 1, sb, set);
                set.remove(chars[i]);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

}
