import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class test1 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        //System.out.println("Hello World!");
        ListNode head=new ListNode(1);
        ListNode head1=new ListNode(2);
        ListNode head2=new ListNode(3);
        ListNode head3=new ListNode(4);
        ListNode head4=new ListNode(5);
        ListNode head5=new ListNode(6);
        head.next=head1;
        head1.next=head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=head5;
        printIn(head);
    }
    public static void printIn(ListNode head)
    {
        ListNode temp=head;
        Deque<Integer> deque=new LinkedList<>();
        while(temp!=null)
        {
            deque.offerLast(temp.val);
            temp=temp.next;

        }

        Stack<Integer> stack=new Stack<>();
        int flag=1;
        while(!deque.isEmpty())
        {
            if(flag==1)
            {
                stack.push(deque.pollLast());
                flag=0;
            }
            else
            {
                stack.push(deque.pollFirst());
                flag=1;
            }


        }

        while(!stack.isEmpty())
        {
            System.out.print(stack.pop()+" ");
        }
    }
}


