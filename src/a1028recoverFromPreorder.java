import java.util.ArrayDeque;
import java.util.Deque;

public class a1028recoverFromPreorder {

    public TreeNode recoverFromPreorder(String traversal) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        int pos = 0;

        while (pos < traversal.length()) {
            int level = 0;
            while (traversal.charAt(pos) == '-') {
                level++;
                pos++;
            }

            int pre = pos;
            while (pos < traversal.length() && Character.isDigit(traversal.charAt(pos))) {
                pos++;
            }
            int value = Integer.parseInt(traversal.substring(pre, pos));
            TreeNode node = new TreeNode(value);
            if (level == deque.size()) {
                if (!deque.isEmpty()) {
                    deque.peekFirst().left = node;
                }
            } else {
                while (level != deque.size()) {
                    deque.pollFirst();
                }
                deque.peekFirst().right = node;
            }
            deque.push(node);
        }
        return deque.peekLast();
    }

    int pos;
    int curDepth;

    public TreeNode recoverFromPreorder2(String traversal) {
        pos = 0;
        curDepth = 0;
        return dfs(traversal, 0);
    }

    private TreeNode dfs(String traversal, int depth) {
        int right = pos;
        while (right < traversal.length() && Character.isDigit(traversal.charAt(right))) {
            right++;
        }
        int val = Integer.parseInt(traversal.substring(pos, right));
        curDepth = 0;
        while (right < traversal.length() && traversal.charAt(right) == '-') {
            curDepth++;
            right++;
        }
        pos = right;
        TreeNode root = new TreeNode(val);
        if (curDepth > depth) root.left = dfs(traversal, depth + 1);
        if (curDepth > depth) root.right = dfs(traversal, depth + 1);
        return root;

    }


}
