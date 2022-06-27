import java.util.ArrayList;
import java.util.List;

public class a0143reorderList {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) break;

            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;

    }

    public void reorderList2(ListNode head) {
        if (head == null || head.next == null) return;

        //寻找中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;
        right = reverseListNode(right);
        merge2List(left, right);
    }

    private void merge2List(ListNode left, ListNode right) {
        ListNode l1;
        ListNode l2;
        while (left != null && right != null) {
            l1 = left.next;
            l2 = right.next;

            left.next = right;
            left = l1;

            right.next = left;
            right = l2;
        }
    }

    private ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}
