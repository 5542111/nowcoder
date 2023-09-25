import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class postorderInMST590 {
    public List<Integer> postorder(FreqNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<FreqNode> stack1 = new Stack<>();
        Stack<FreqNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            FreqNode temp = stack1.pop();
            stack2.push(temp);
            while (!temp.children.isEmpty()) {
                stack1.push(temp.children.get(0));
                temp.children.remove(0);
            }
            while (!stack2.isEmpty()) {
                list.add(stack2.pop().val);
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
        Collections.reverse(list);
        return list;
    }
}

class Node {
    public int val;
    public List<FreqNode> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<FreqNode> _children) {
        val = _val;
        children = _children;
    }
};