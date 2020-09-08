import java.util.*;


public class buildTree105 {

    /**
     * @param preorder
     * @param inorder
     * @param pre_left
     * @param pre_right
     * @param in_left
     * @param in_right
     * @param hashMap
     * @return
     */
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right, Map<Integer, Integer> hashMap) {
        if (pre_left > pre_right) {
            return null;
        }
        //获取前序的根结点 index
        int pre_root = pre_left;
        //获取中序的根结点 index
        int in_root = hashMap.get(preorder[pre_root]);

        //建立根结点
        TreeNode root = new TreeNode(preorder[pre_root]);

        //获取左子树的节点数目

        int left_subtree_size = in_root - in_left;
        root.left = myBuildTree(preorder, inorder, pre_left + 1, pre_left + left_subtree_size, in_left, in_root - 1, hashMap);
        root.right = myBuildTree(preorder, inorder, pre_left + left_subtree_size + 1, pre_right, in_root + 1, in_right, hashMap);
        return root;

    }

    /**
     * 中序 与 先序 重建 二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int size = inorder.length;
        for (int i = 0; i < size; i++) {
            hashMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, size - 1, 0, size - 1, hashMap);
    }

    /**
     * 中序 与 后序 重建 二叉树
     *
     * @param postorder
     * @param inorder
     * @return
     */

    public TreeNode buildTree2(int[] postorder, int[] inorder) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int size = inorder.length;
        for (int i = 0; i < size; i++) {
            hashMap.put(inorder[i], i);
        }
        return myBuildTree2(postorder, inorder, 0, size - 1, 0, size - 1, hashMap);
    }

    /**
     * @param postorder
     * @param inorder
     * @param post_left
     * @param post_right
     * @param in_left
     * @param in_right
     * @param hashMap
     * @return
     */

    public TreeNode myBuildTree2(int[] postorder, int[] inorder, int post_left, int post_right, int in_left, int in_right, Map<Integer, Integer> hashMap) {
        if (post_left > post_right) {
            return null;
        }
        //获取 后序遍历 根结点 index
        int post_root = post_right;
        //获取中序遍历 根结点 index
        int in_root = hashMap.get(postorder[post_root]);
        System.out.println(in_root);
        TreeNode root = new TreeNode(postorder[post_root]);

        int right_subtree_size = in_right - in_root;

        root.right = myBuildTree2(postorder, inorder, post_root - right_subtree_size, post_root - 1, in_root + 1, in_right, hashMap);
        root.left = myBuildTree2(postorder, inorder, post_left, post_root - right_subtree_size - 1, in_left, in_root - 1, hashMap);
        return root;
    }
}
