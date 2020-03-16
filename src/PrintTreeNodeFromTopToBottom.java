import java.util.ArrayList;

public class PrintTreeNodeFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null) {
            return list;

        }
        /**
         * 模仿入队出队操作
         */
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode tmp = queue.remove(0);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
            list.add(tmp.val);
        }

        return list;
    }
}
