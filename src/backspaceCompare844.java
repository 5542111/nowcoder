import java.util.Stack;

public class backspaceCompare844 {
    public static void main(String[] args) {
        System.out.println(new backspaceCompare844().backspaceCompare("ab#c", "#c"));
    }

    public boolean backspaceCompare(String S, String T) {
        return backspaceCompareHelper(S).equals(backspaceCompareHelper(T));
    }
    private String backspaceCompareHelper(String S){
        if(S==null||S.length()==0) return "";
        char[] chars=S.toCharArray();

        Stack<Character> stack=new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='#') {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(chars[i]);
            }
        }
        StringBuilder res=new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }
}
