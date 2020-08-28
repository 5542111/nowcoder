import java.util.Stack;

public class getIntersectionNode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode res=new ListNode();
        Stack<ListNode> stackA=new Stack<>();
        Stack<ListNode> stackB=new Stack<>();

        while (headA!=null){
            stackA.push(headA);
            headA=headA.next;
        }
        while (headB!=null){
            stackB.push(headB);
            headB=headB.next;
        }
        while (!stackA.isEmpty()&&!stackB.isEmpty()){
            ListNode tempA=stackA.pop();
            ListNode tempB=stackB.pop();
            if (tempA.val==tempB.val){
                res=tempA;
            }
            else {
                res=res.next;
                break;
            }
        }

        return res;
    }
}
