import java.util.Stack;

public class bstToGst1038 {
    public TreeNode bstToGst(TreeNode root) {
        TreeNode p=root;

        Stack<TreeNode> stack=new Stack<>();
        Stack<Integer> res=new Stack<>();
        int sum=0;
        while(p!=null || !stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p=p.left;
            }
            p=stack.pop();
            res.add(p.val);
            sum+=p.val;

            p=p.right;
        }
        System.out.println(sum);
        int pre=0;

        p=root;
        while(p!=null || !stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p=p.left;
            }
            p=stack.pop();

            sum-=pre;
            pre=p.val;
            p.val=sum;

            p=p.right;
        }

        return root;
    }
}
