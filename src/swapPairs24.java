public class swapPairs24 {
    public ListNode swapPairs(ListNode head) {
//           if (head==null||head.next==null){
//             return head;
//         }
//         ListNode node=head.next;

//         head.next=swapPairs(node.next);
//         node.next=head;


//         return node;
        ListNode node = new ListNode(0);
        node.next = head;

        ListNode temp = node;


        while (temp.next != null && temp.next.next != null){
            ListNode pre=temp.next;
            ListNode back=temp.next.next;
            temp.next=back;
            pre.next=back.next;
            back.next=pre;
            temp=pre;
        }

        return node.next;
    }
}
