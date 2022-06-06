import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class o0043CBTInserter {
    TreeNode root;
    List<TreeNode> nodes;

    public o0043CBTInserter(TreeNode root) {
        this.root = root;
        nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            nodes.add(poll);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }

    }

    public int insert(int v) {
        TreeNode tail = nodes.get((nodes.size() - 1) / 2);
        if (tail.left == null) {
            tail.left = new TreeNode(v);
            nodes.add(tail.left);
        } else {
            tail.right = new TreeNode(v);
            nodes.add(tail.right);
        }
        return tail.val;
    }

    public TreeNode get_root() {
        return nodes.get(0);
    }
}
