import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class postorderInMST590 {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node temp = stack1.pop();
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
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};