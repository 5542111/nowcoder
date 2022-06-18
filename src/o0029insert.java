public class o0029insert {
    public Node1 insert(Node1 head, int insertVal) {
        Node1 node = new Node1(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node1 slow = head;
        Node1 fast = slow.next;
        if (fast == head) {
            slow.next = node;
            node.next = head;
            return head;
        }
        while (fast != head) {
            if (slow.val <= insertVal && fast.val >= insertVal) {
                break;
            }
            if (slow.val > fast.val) {
                if (slow.val < insertVal || fast.val > insertVal) {
                    break;
                }

            }
            slow = slow.next;
            fast = slow.next;

        }
        slow.next = node;
        node.next = fast;
        return head;
    }
}

class Node1 {
    public int val;
    public Node1 next;

    public Node1() {
    }

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _next) {
        val = _val;
        next = _next;
    }
};