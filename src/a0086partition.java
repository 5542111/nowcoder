import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class a0086partition {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        Queue<ListNode> queueLess = new LinkedList<>();
        Queue<ListNode> queueMore = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                queueLess.add(cur);
            } else {
                queueMore.add(cur);
            }
            cur = cur.next;
        }
        ListNode ans = new ListNode(0);
        ListNode curr = new ListNode(!queueLess.isEmpty() ? queueLess.poll().val : queueMore.poll().val);
        ans.next = curr;
        while (!queueLess.isEmpty()) {
            curr.next = new ListNode(queueLess.poll().val);
            curr = curr.next;
        }
        while (!queueMore.isEmpty()) {
            curr.next = new ListNode(queueMore.poll().val);
            curr = curr.next;
        }

        return ans.next;
    }

    public ListNode partition2(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode large = largeHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                small.next = cur;
                small = small.next;
            } else {
                large.next = cur;
                large = large.next;
            }
            cur = cur.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
