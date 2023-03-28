public class a1092shortestCommonSupersequence {
    private String s, t;

    //  private String[][] memo;

    private int[][] memo;

    public String shortestCommonSupersequence(String str1, String str2) {
        s = str1;
        t = str2;
        //memo = new String[s.length()][t.length()];
        memo = new int[s.length()][t.length()];
        return makeAns(s.length() - 1, t.length() - 1);
    }

//    public String dfs(int i, int j) {
//        if (i < 0) return t.substring(0, j + 1);
//        if (j < 0) return s.substring(0, i + 1);
//        if (memo[i][j] != null) return memo[i][j];
//        if (s.charAt(i) == t.charAt(j)) {
//            return memo[i][j] = dfs(i - 1, j - 1) + s.charAt(i);
//        }
//        String s1 = dfs(i - 1, j);
//        String t1 = dfs(i, j - 1);
//        if (s1.length() < t1.length()) {
//            return memo[i][j] = s1 + s.charAt(i);
//        }
//        return memo[i][j] = t1 + t.charAt(j);
//    }


    // dfs(i,j) 返回 s 的前 i 个字母和 t 的前 j 个字母的最短公共超序列的长度
    private int dfs(int i, int j) {
        if (i < 0) return j + 1; // s 是空串，返回剩余的 t 的长度
        if (j < 0) return i + 1; // t 是空串，返回剩余的 s 的长度
        if (memo[i][j] > 0) return memo[i][j]; // 避免重复计算 dfs 的结果
        if (s.charAt(i) == t.charAt(j)) // 最短公共超序列一定包含 s[i]
            return memo[i][j] = dfs(i - 1, j - 1) + 1;
        return memo[i][j] = Math.min(dfs(i - 1, j), dfs(i, j - 1)) + 1;
    }

    // makeAns(i,j) 返回 s 的前 i 个字母和 t 的前 j 个字母的最短公共超序列
    // 看上去和 dfs 没啥区别，但是末尾的递归是 if-else
    // makeAns(i-1,j) 和 makeAns(i,j-1) 不会都调用
    // 所以 makeAns 的递归树仅仅是一条链
    private String makeAns(int i, int j) {
        if (i < 0) return t.substring(0, j + 1); // s 是空串，返回剩余的 t
        if (j < 0) return s.substring(0, i + 1); // t 是空串，返回剩余的 s
        if (s.charAt(i) == t.charAt(j)) // 最短公共超序列一定包含 s[i]
            return makeAns(i - 1, j - 1) + s.charAt(i);
        // 如果下面 if 成立，说明上面 dfs 中的 min 取的是 dfs(i - 1, j)
        // 说明 dfs(i - 1, j) 对应的公共超序列更短
        // 那么就在 makeAns(i - 1, j) 的结果后面加上 s[i]
        // 否则说明 dfs(i, j - 1) 对应的公共超序列更短
        // 那么就在 makeAns(i, j - 1) 的结果后面加上 t[j]
        if (dfs(i, j) == dfs(i - 1, j) + 1)
            return makeAns(i - 1, j) + s.charAt(i);
        return makeAns(i, j - 1) + t.charAt(j);
    }
}