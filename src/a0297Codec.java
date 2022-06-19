import java.util.*;

public class a0297Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return dfs(root,"");
    }

    private String dfs(TreeNode root, String str) {
        if (root == null) str += "null,";
        else {
            str += root.val + ",";
            str = dfs(root.left,str);
            str = dfs(root.right,str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        if (split.length == 0) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(split));
        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> dataList) {
        if (dataList.peek().equals("null")) {
            dataList.poll();
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(dataList.poll()));
        root.left = dfs(dataList);
        root.right = dfs(dataList);

        return root;
    }
}
