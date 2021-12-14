import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class a0133oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        Queue<ListNode> odd = new LinkedList<>();
        Queue<ListNode> even = new LinkedList<>();
        boolean flag = false;
        while (head != null) {
            if (flag) even.add(head);
            else odd.add(head);
            flag = !flag;
            head = head.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        int total=odd.size()+even.size();
        while (!odd.isEmpty()){
            dummy.next=odd.poll();
            dummy =dummy.next;
        }
        while (!even.isEmpty()){
            dummy.next=even.poll();
            dummy =dummy.next;
        }
        if (total%2==1){
            dummy.next=null;
        }
        return res;
    }
}
