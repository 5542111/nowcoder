import java.util.ArrayList;
import java.util.List;

public class letterCombinations17 {
    public static void main(String[] args) {
        System.out.println(new letterCombinations17().letterCombinations("234"));
    }
    char[][] chars=new char[][]{
            {},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'},
    };
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();

        dfs(digits, 0, new StringBuffer(), res);
        return res;
    }

    public void dfs(String digits, int index, StringBuffer stringBuffer, List<String> res) {
        if (index == digits.length()) {
            res.add(stringBuffer.toString());
            return;
        }
        for(char c:chars[digits.charAt(index)-'0']){
            stringBuffer.append(c);
            dfs(digits,index+1,stringBuffer,res);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }

    }


}
