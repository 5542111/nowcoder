import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeToList114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        //先序遍历转链表
        Queue<TreeNode> res=new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        TreeNode temp=res.poll();
        root=temp;
        root.left=null;
        while (!res.isEmpty())
        {
            temp.right=res.poll();
            temp=temp.right;
        }


    }
}
