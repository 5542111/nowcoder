import java.util.LinkedList;
import java.util.Queue;

public class a0117connect {
    public Node connect(Node root) {
        if (root == null) return null;
        Node temp = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                poll.next = prev;
                prev = poll;
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                if (poll.left!=null){
                    queue.add(poll.left);
                }
            }
        }
        return temp;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}



