public class hasCycle141 {
    public boolean hasCycle141(ListNode head) {
        if (head == null)
            return false;
        if (head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow!=fast ) {
            if (fast == null || fast.next == null) {
                return false;
            }
          //  System.out.println(slow.val + "," + fast.val);
            slow = slow.next;
            fast = fast.next.next;
        }
       return true;

    }
    public ListNode hasCycle142(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        //如果快指针走到尽头，没环
        if(fast == null || fast.next == null) return null;
        //快指针重新出发，相遇位置就是入口位置
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;


    }

}
