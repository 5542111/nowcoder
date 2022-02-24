public class a0023mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int L, int R) {
        if (L == R) return lists[L];
        if (L > R) return null;
        int mid = (L + R) / 2;
        return merge2List(merge(lists, L, mid), merge(lists, mid + 1, R));
    }

    private ListNode merge2List(ListNode p, ListNode q) {
        if (p == null || q == null) return p != null ? p : q;
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while (p != null && q != null) {
            if (p.val < q.val) {
                res.next = p;
                p = p.next;
            } else {
                res.next = q;
                q = q.next;
            }
            res = res.next;
        }
        res.next = (p == null ? q : p);
        return dummy.next;
    }
}
