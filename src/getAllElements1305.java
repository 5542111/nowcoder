import java.util.*;

public class getAllElements1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> res = new ArrayList<>();

        List<Integer> list1 = inorderTraversal(root1);

        List<Integer> list2 = inorderTraversal(root2);

        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                res.add(list1.get(i));
                i++;
            } else {
                res.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()) {
            res.add(list1.get(i++));
        }
        while (j < list1.size()) {
            res.add(list1.get(j++));
        }

        return res;

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if (root != null && root.left != null) {
                stack.push(root.left);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                    root = root.right;
                } else {
                    root = null;
                }
            }
        }
        return res;
    }

}
