public class a0019removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode quick = head;
        for (int i = 0; i < n; i++) {
            quick = quick.next;
        }
        ListNode slow = head;
        ListNode pre = null;
        while (quick != null) {
            pre = slow;
            quick = quick.next;
            slow = slow.next;
        }
        if (pre == null) {
            head = slow.next;
        } else {
            pre.next = slow.next;
        }

        return head;
    }
}
