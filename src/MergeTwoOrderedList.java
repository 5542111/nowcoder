import java.sql.ClientInfoStatus;
import java.util.List;

public class MergeTwoOrderedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        Merge(l1, l2);
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode temp = new ListNode(0);
        temp.next = null;
        ListNode head = temp.next;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;


            } else {
                System.out.println(0);
                temp.next = list2;
                temp = list2;
                list2 = list2.next;

            }

        }


        if (list1 == null) {
            temp.next = list2;
        }
        if (list2 == null) {
            temp.next = list1;
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;


        ListNode temp = new ListNode(0);
        ListNode tmp = temp;
        while (l1 != null & l2 != null) {

            if (l1.val <= l2.val) {
                tmp.next = l1;
                l1 = l1.next;

            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;

        }

        if (l1 == null) {
            tmp.next = l2;
        }
        if (l2 == null) {
            tmp.next = l1;
        }

        return temp.next;


    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;

    }

    public ListNode rotateRight(ListNode head, int k) {

        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for (n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode pre = head;
        ListNode latter = temp;

        while (pre != null) {
            if (pre.next != null && pre.val == pre.next.val) {

                // internal circulation, stop when pre != pre.next
//                do {
//                    pre = pre.next;
//                } while (pre.next != null && pre.val == pre.next.val);
                while (pre.next != null && pre.val == pre.next.val){
                    pre=pre.next;

                    // change pointer
                }
                latter.next = pre.next;
                pre = pre.next;
            } else {

                // when pre != pre.next , two pointer move backward as the same time
                pre = pre.next;
                latter = latter.next;
            }


        }

        return temp.next;
    }


}
