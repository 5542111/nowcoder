public class a2095deleteMiddle {


    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode pre = head;
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            index++;
            cur = cur.next;
        }
        int idx = index / 2;
        int curIndex = 0;
        ListNode p = new ListNode(0);
        p.next = pre;
        while (pre != null && curIndex < idx) {
            curIndex++;
            pre = pre.next;
            p = p.next;
        }

        if (pre == null || pre.next == null) {
            p.next = null;
        } else {
            p.next = pre.next;
            pre.next = null;
        }


        return head;
    }

    public ListNode deleteMiddle2(ListNode head) {
        if (head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        ListNode pre = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
