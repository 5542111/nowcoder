import java.util.*;

public class zigzagLevelOrder103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = deque.pollFirst();
                temp.add(tmp.val);
                if (tmp.left != null) {
                    deque.add(tmp.left);
                }
                if (tmp.right != null) {
                    deque.add(tmp.right);
                }

            }
            res.add(temp);
        }
        List<List<Integer>> ans = new ArrayList<>();
        int depth = 0;
        for (int i = 0; i < res.size(); i++) {
            if (depth % 2 == 0) {
                ans.add(res.get(i));
            } else {
                List<Integer> list = new ArrayList<>();
                List<Integer> ll = res.get(i);
                for (int j = ll.size() - 1; j >= 0; j--) {
                    list.add(ll.get(j));
                }
                ans.add(list);
            }
            depth++;
        }
        return ans;
    }
}
