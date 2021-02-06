import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class addTwoNumInversePrint02 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node= new ListNode(0);
        int sum=0;
        ListNode curr=node;
        while(l1!=null || l2!=null)
        {
            if (l1!=null)
            {
                sum+=l1.val;
                l1=l1.next;
            }

            if (l2!=null)
            {
                sum+=l2.val;
                l2=l2.next;
            }
            node.next=new ListNode(sum%10);
            sum/=10;
            node=node.next;
        }
        if (sum==1)
            node.next=new ListNode(1);


        return curr.next;

    }
}
