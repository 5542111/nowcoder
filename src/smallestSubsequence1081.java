import java.util.Stack;

public class smallestSubsequence1081 {
    public String smallestSubsequence(String text) {


        Stack<Character> stack=new Stack<>();
        for (int i=0;i<text.length();i++)
        {
            char ch=text.charAt(i);
            if (stack.contains(ch))
            {
                continue;
            }
            while (!stack.isEmpty() && ch< stack.peek() && text.lastIndexOf(stack.peek()) > i) {
                stack.pop();
            }
            stack.push(ch);


        }
        StringBuffer ans=new StringBuffer();
        while (!stack.isEmpty())
        {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
