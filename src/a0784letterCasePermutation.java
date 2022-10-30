import java.util.ArrayList;
import java.util.List;

public class a0784letterCasePermutation {
    public static void main(String[] args) {
        System.out.println(new a0784letterCasePermutation().letterCasePermutation("a1bn2"));
    }
    List<String> res = new ArrayList<String>();

    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        dfs(chars,0);
        return res;
    }


    private void dfs(char[] chars, int index) {
        res.add(new String(chars));
        for (int i = index; i < chars.length; i++) {
            if (Character.isLetter(chars[i]) && Character.isLetter(chars[i] - 32)) {
                chars[i] = (char) (chars[i] - 32);
                dfs(chars,i+1);
                chars[i] = (char) (chars[i] + 32);
            }
        }
    }
}
