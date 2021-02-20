import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class preorderInNTree589 {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        stack.push(root);


        while (!stack.isEmpty()) {
            Node temp = stack.pop();

            res.add(temp.val);


            if (!temp.children.isEmpty()) {
                Collections.reverse(temp.children);
                for (Node node : temp.children) {
                    stack.push(node);
                }
            }

        }
        return res;
    }

}


