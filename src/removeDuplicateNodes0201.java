import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class removeDuplicateNodes0201 {
    public ListNode removeDuplicateNodes(ListNode head) {

        List<ListNode> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        while (head != null) {
            if (!tmp.contains(head.val)) {
                list.add(head);
                tmp.add(head.val);
            }
            System.out.println(list);
            System.out.println(tmp);
            head = head.next;
        }
        ListNode res = new ListNode(0);
        ListNode ans = res.next;
        for (Integer integer : tmp) {
            ListNode temp = new ListNode(integer);
            res.next = temp;
            res = temp;
        }

        return ans;
    }

    public ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        Set<Integer> hs = new HashSet<>();
        hs.add(head.val);
        while (cur.next != null) {
            ListNode tmp = cur.next;
            if (hs.add(tmp.val)) {
                cur = cur.next;
            }
            else {
                hs.add(tmp.val);
                cur.next=tmp.next;
            }
        }
        return head;
    }
}
