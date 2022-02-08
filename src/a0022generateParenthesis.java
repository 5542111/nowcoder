import java.util.ArrayList;
import java.util.List;

public class a0022generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisHelper(n, new StringBuilder(), res, n, n);
        return res;
    }

    /**
     * @param len   总括号对数
     * @param path  生成的中间括号str
     * @param res   符合条件的括号对
     * @param left  左括号数量
     * @param right 右括号数量
     */
    public void generateParenthesisHelper(int len, StringBuilder path, List<String> res, int left, int right) {
        if (path.length() == 2 * len) {
            res.add(path.toString());
            return;
        }
        if (left > 0) {
            left--;
            path.append("(");
            generateParenthesisHelper(len, path, res, left, right);
            path.deleteCharAt(path.length() - 1);
            left++;
        }
        if (right > 0 && left < right) {
            right--;
            path.append(")");
            generateParenthesisHelper(len, path, res, left, right);
            path.deleteCharAt(path.length() - 1);
            right++;
        }
    }
}
