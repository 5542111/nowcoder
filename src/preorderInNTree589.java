import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class preorderInNTree589 {
    public List<Integer> preorder(FreqNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();

        Stack<FreqNode> stack = new Stack<>();
        stack.push(root);


        while (!stack.isEmpty()) {
            FreqNode temp = stack.pop();

            res.add(temp.val);


            if (!temp.children.isEmpty()) {
                Collections.reverse(temp.children);
                for (FreqNode freqNode : temp.children) {
                    stack.push(freqNode);
                }
            }

        }
        return res;
    }

}


