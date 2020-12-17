
import java.util.List;
import java.util.Stack;

public class addTwoNumbers445 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l1.next = l11;
        l11.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(5);

        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(7);

        l2.next = l21;
        l21.next = l22;

        ListNode cur = addTwoNumbers(l1, l2);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();

        Stack<Integer> stack2 = new Stack<>();
        ListNode cur = l1;
        while (cur != null) {
            stack1.push(cur.val);
            cur = cur.next;
        }

        cur = l2;
        while (cur != null) {
            stack2.push(cur.val);
            cur = cur.next;
        }

        Stack<Integer> stack = new Stack<>();
        int now = 0;
        int flag = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {


            int value1 = !stack1.isEmpty() ? stack1.pop() : 0;
            int value2 = !stack2.isEmpty() ? stack2.pop() : 0;
            now = (value1 + value2) % 10;
            flag = (value1 + value2) / 10;
            stack.push(now);


            if (flag != 0) {
                int temp = !stack1.isEmpty() ? stack1.pop() : 0;
                stack1.push(temp + flag);


            }
        }


        ListNode res = new ListNode(0);
        ListNode head=res;
        while (!stack.isEmpty()) {
            res.next=new ListNode(stack.pop());
            res=res.next;
        }

        return head.next;

    }
}
