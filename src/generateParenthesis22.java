import java.util.ArrayList;
import java.util.List;

public class generateParenthesis22 {
    public static void main(String[] args) {
        System.out.println(new generateParenthesis22().generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        int left=n;
        int right=n;
        dfs(n,left,right,new StringBuffer(""),res);
        return res;

    }

    public void dfs(int length, int left, int right, StringBuffer stringBuffer, List<String> res) {
        if (stringBuffer.length() == 2 * length) {
            res.add(stringBuffer.toString());
            //System.out.println(res);
            return;
        }
        if (left > 0) {
            left--;
            stringBuffer.append("(");
            dfs(length, left, right, stringBuffer, res);
            left++;
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
        if (right > 0 && left != right) {
            right--;
            stringBuffer.append(")");
            dfs(length, left, right, stringBuffer, res);
            right++;
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }

    }
}
