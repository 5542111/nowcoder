import java.util.ArrayList;
import java.util.List;

public class a0842splitIntoFibonacci {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = new ArrayList<>();
        dfs(num, res, 0);
        return res;
    }

    //拆分为 类似斐波那契数列形式的  F（n） = F（n-1）+F（n-2）
    private boolean dfs(String str, List<Integer> res, int index) {
        if (index == str.length()) return res.size() >= 3;
        for (int i = index; i < str.length(); i++) {
            if (str.charAt(index) == '0' && i > index) {
                break;
            }
            long sum = 0;
            for (int j = index; j < i + 1; j++) {
                sum = sum * 10 + str.charAt(j) - '0';
            }
            if (sum > Integer.MAX_VALUE) break;
            int size = res.size();
            if (size >= 2 && sum > res.get(size - 1) + res.get(size - 2)) {
                break;
            }
            if (size <= 1 || sum == res.get(size - 1) + res.get(size - 2)) {
                res.add((int) sum);
                if (dfs(str, res, i + 1)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}
