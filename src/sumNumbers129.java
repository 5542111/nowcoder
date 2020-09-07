public class sumNumbers129 {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, new StringBuffer());
        return sum;
    }


    private void dfs(TreeNode root, StringBuffer sb) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            sum += Integer.parseInt(sb.toString());
            return;
        }
        if (root != null) {
            sb.append(root.val);
            if (root.left != null) {
                dfs(root.left, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (root.right != null) {
                dfs(root.right, sb);
                sb.deleteCharAt(sb.length() - 1);
            }

        }
    }
}
