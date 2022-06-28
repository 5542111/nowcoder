import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class a0662widthOfBinaryTree {
    /**
     * https://leetcode.cn/problems/maximum-width-of-binary-tree/solution/by-mou-zi-ming-z-naex/
     * BFS
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int res = 1;

        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        Deque<Integer> indexQueue = new ArrayDeque<>();

        nodeDeque.offerLast(root);
        indexQueue.offerLast(1);
        while (!nodeDeque.isEmpty()) {

            int size = nodeDeque.size();
            int tmpWidth = 0;
            boolean isFirstNode = true;
            int left = -1, right = -1;

            while (size-- > 0) {
                TreeNode treeNode = nodeDeque.pollFirst();
                Integer pos = indexQueue.pollFirst();
                if (isFirstNode) {
                    isFirstNode = false;
                    left = pos;
                }
                right = pos;

                tmpWidth = Math.max(tmpWidth, right - left + 1);
                if (treeNode.left != null) {
                    nodeDeque.offerLast(treeNode.left);
                    indexQueue.offerLast(pos * 2);
                }
                if (treeNode.right != null) {
                    nodeDeque.offerLast(treeNode.right);
                    indexQueue.offerLast(pos * 2 + 1);
                }
            }
            res = Math.max(res, tmpWidth);
        }
        return res;
    }

    /**
     * dfs
     *
     * @param root
     * @return
     */
    int ans;

    public int widthOfBinaryTree2(TreeNode root) {
        ans = 0;
        Map<Integer, Integer> left = new HashMap<>();
        dfs(root, 0, 0, left);
        return ans;
    }

    private void dfs(TreeNode root, int depth, int pos, Map<Integer, Integer> left) {
        if (root == null) return;
        //这是左节点处理的时机
        left.putIfAbsent(depth, pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos, left);
        dfs(root.right, depth + 1, 2 * pos + 1, left);
    }


}
