public class reverseList24 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
        {
            return head;
        }
        ListNode pre=head;
        ListNode cur=null;
        while(pre!=null)
        {
            ListNode temp=pre.next;
            pre.next=cur;
            cur=pre;
            pre=temp;
        }
        return cur;
    }
}
