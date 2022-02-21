import java.util.ArrayList;
import java.util.List;

public class o0087restoreIpAddresses {
    public static void main(String[] args) {
        System.out.println(new o0087restoreIpAddresses().restoreIpAddresses("0000"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12) return res;
        dfs(s, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(String s, List<String> res, List<String> path, int index) {
        if (index == s.length() && path.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(path.get(i));
                if (i < 3) sb.append(".");
            }
            res.add(sb.toString());
            return;
        }
        int n = Math.min(index + 3, s.length());

        for (int i = index; i < n; i++) {
            String substring = s.substring(index, i + 1);
            int tempNum = Integer.parseInt(substring);
            if (tempNum > 255 || (tempNum > 0 && substring.charAt(0) - '0' == 0) || (tempNum == 0 && substring.length() > 1))
                continue;
            path.add(substring);
            dfs(s, res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
