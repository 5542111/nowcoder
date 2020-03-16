import java.util.ArrayList;

public class FindPathInTree {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null) {
            return res;
        }


        list.add(root.val);
        //判断到达叶节点
        if ((target - root.val == 0) && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }

        FindPath(root.left, target - root.val);
        FindPath(root.right, target - root.val);


        list.remove(list.size()-1);



        return res;


    }

}
