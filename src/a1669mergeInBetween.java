public class a1669mergeInBetween {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode();
        dummy.next = list1;

        ListNode slow = list1;

        ListNode fast = list1.next;
        ListNode tmp = list2;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        while (b > 0) {
            fast = fast.next;
            b--;
        }
        tmp.next = fast;
        while (a > 1) {
            slow = slow.next;
            a--;
        }
        slow.next = list2;
        return dummy.next;
    }

}
