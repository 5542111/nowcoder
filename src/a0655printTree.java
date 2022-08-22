import java.util.*;

public class a0655printTree {
    public List<List<String>> printTree(TreeNode root) {
        int depth = getDepth(root);
        String[][] ans = new String[depth][(1 << depth) - 1];
        for (String[] an : ans) {
            Arrays.fill(an, "");
        }
        List<List<String>> res = new ArrayList<>();
        fill(ans, root, 0, 0, (1 << depth) - 1);
        for (String[] an : ans) {
            res.add(Arrays.asList(an));
        }

        return res;
    }

    private void fill(String[][] ans, TreeNode root, int i, int left, int right) {
        if (root == null) return;

        ans[i][(left + right) / 2] = String.valueOf(root.val);
        fill(ans, root.left, i + 1, left, (left + right) / 2);
        fill(ans, root.right, i + 1, (left + right + 1) / 2, right);
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
