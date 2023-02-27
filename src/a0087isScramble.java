import java.util.HashMap;
import java.util.Map;

public class a0087isScramble {

    private int[][][] memo;
    private String s;
    private String t;

    public boolean isScramble(String s1, String s2) {
        s = s1;
        t = s2;
        int m = s.length();
        memo = new int[m][m][m + 1];

        return dfs(0, 0, m);

    }

    private boolean dfs(int i, int j, int len) {
        if (memo[i][j][len] != 0) {
            return memo[i][j][len] == 1;
        }
        String sTemp = s.substring(i, i + len);
        String tTemp = t.substring(j, j + len);
        if (sTemp.equals(tTemp)) {
            memo[i][j][len] = 1;
            return true;
        }
        if (!isSimilar(sTemp, tTemp)) {
            memo[i][j][len] = -1;
            return false;
        }
        for (int k = 1; k < len; k++) {
            //不交换
            if (dfs(i, j, k) && dfs(i + k, j + k, len - k)) {
                memo[i][j][len] = 1;
                return true;
            }

            //交换
            if (dfs(i, j + len - k, k) && dfs(i + k, j, len - k)) {
                memo[i][j][len] = 1;
                return true;
            }
        }
        memo[i][j][len] = 1;
        return false;
    }

    private boolean isSimilar(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        return map.values().stream().noneMatch(it -> it != 0);
    }
}
