public class a0148sortListNode {
    private ListNode head;
    private ListNode tail;

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = split(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);

    }

    private ListNode split(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        //从中间切断
        pre.next = null;
        return slow;
    }


    private ListNode merge(ListNode left, ListNode right) {
        head = null;
        tail = null;
        ListNode q = left;
        ListNode p = right;
        while (q != null || p != null) {
            if (q == null) {
                append(p);
                p = p.next;
            } else if (p == null) {
                append(q);
                q = q.next;
            } else if (q.val < p.val) {
                append(q);
                q = q.next;
            } else {
                append(p);
                p = p.next;
            }
        }
        return head;
    }

    private void append(ListNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

}
