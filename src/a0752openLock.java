import java.util.*;

public class a0752openLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Deque<String> deque = new ArrayDeque<>();
        deque.add("0000");
        if (!deadSet.add("0000")) {
            return -1;
        }

        int res = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String temp = deque.pollFirst();
                if (target.equals(temp)) return res;
                for (int j = 0; j < 4; j++) {
                    String up = up(temp, j);
                    String down = down(temp, j);
                    if (deadSet.add(up)) {
                        deque.offerLast(up);
                    }
                    if (deadSet.add(down)) {
                        deque.offerLast(down);
                    }
                }
            }
            res++;
        }

        return -1;
    }

    private String up(String now, int index) {
        char[] cur = now.toCharArray();
        if (cur[index] == '9') cur[index] = '0';
        else cur[index] += 1;
        return new String(cur);
    }

    private String down(String now, int index) {
        char[] cur = now.toCharArray();
        if (cur[index] == '0') cur[index] = '9';
        else cur[index] -= 1;
        return new String(cur);
    }
}
