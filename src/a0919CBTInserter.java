import java.util.ArrayDeque;
import java.util.Queue;

public class a0919CBTInserter {
    Queue<TreeNode> unsatisfyNodes;
    TreeNode root;

    public a0919CBTInserter(TreeNode root) {
        this.unsatisfyNodes = new ArrayDeque<>();
        this.root = root;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (!(node.left != null && node.right != null)) {
                this.unsatisfyNodes.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode peek = unsatisfyNodes.peek();
        int ret = peek.val;
        if (peek.left == null) {
            peek.left = child;
        } else {
            peek.right = child;
            unsatisfyNodes.poll();
        }
        unsatisfyNodes.offer(child);
        return ret;
    }

    public TreeNode get_root() {
        return root;
    }

}
