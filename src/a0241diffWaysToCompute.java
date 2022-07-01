import java.util.ArrayList;
import java.util.List;

public class a0241diffWaysToCompute {
    public List<Integer> diffWaysToCompute(String expression) {
        return dfs(expression, 0, expression.length() - 1);
    }

    private List<Integer> dfs(String expression, int l, int r) {
        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (Character.isDigit(expression.charAt(i))) continue;
            List<Integer> lLeft = dfs(expression, l, i - 1);
            List<Integer> rRight = dfs(expression, i + 1, r);
            for (int lItem : lLeft) {
                for (int rItem : rRight) {
                    int cur = 0;
                    if (expression.charAt(i) == '+') cur = lItem + rItem;
                    else if (expression.charAt(i) == '-') cur = lItem - rItem;
                    else if (expression.charAt(i) == '*') cur = lItem * rItem;
                    else cur = lItem / rItem;
                    res.add(cur);
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression.substring(l, r + 1)));
        }
        return res;
    }
}
