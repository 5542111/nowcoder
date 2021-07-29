public class a0092reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode ans = res;

        int minus = right - left;

        while (left > 1) {
            res = res.next;
            left--;
        }
        ListNode cur = res.next;

        while (minus > 0) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = res.next;
            res.next = next;


            minus--;
        }

        return ans.next;

    }
}
