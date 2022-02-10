public class a0876middleNode {
    public ListNode middleNode(ListNode head) {
        ListNode quick=head;
        ListNode slow=head;

        while (quick!=null && quick.next!=null){
            quick=quick.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
