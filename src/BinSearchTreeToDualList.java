import com.sun.org.apache.xpath.internal.objects.XObject;
import javafx.geometry.Pos;
import javafx.util.Pair;
import sun.plugin2.ipc.windows.WindowsIPCFactory;
import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

public class BinSearchTreeToDualList {
    public static void main(String[] args) {


        TreeNode root = new TreeNode(15);


        TreeNode node1 = new TreeNode(13);
        TreeNode node2 = new TreeNode(17);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(14);
        TreeNode node5 = new TreeNode(16);
        TreeNode node6 = new TreeNode(18);
        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;
        //PreOrder(root);
        InOrder(root);
        //PostOrder(root);
        //InOrder2(root);
//        Convert(root);
        //BroadFirstSearch(root);
        //DepthFirstSearch(root);
        // printInZigZagShape(root);

        //System.out.println(diameterOfBinaryTree(root));
        //BroadFirstSearch(root);
        //mirrorTree(root);
        //BroadFirstSearch(root);

    }

    public static void PreOrder(TreeNode p) {
        if (p == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = p;
        stack.push(root);
        while (!stack.isEmpty()) {
            if (root != null) {
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }

    }

    public static void InOrder(TreeNode p) {
        if (p == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = p;
        stack.push(root);
        while (!stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                //System.out.println(root.val);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    public static void PostOrder(TreeNode p) {
        if (p == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack.push(p);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            stack1.push(cur);

            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop().val);
        }
    }

    public static void InOrder2(TreeNode p) {
        if (p != null) {
            InOrder2(p.left);
            System.out.println(p.val);
            InOrder2(p.right);
        }
    }

    public static void BroadFirstSearch(TreeNode p) {
        if (p == null) {
            return;
        }

        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(p);
        while (!myQueue.isEmpty()) {
            TreeNode temp = myQueue.poll();
            System.out.println(temp.val);
            if (temp.left != null) {
                myQueue.add(temp.left);
            }
            if (temp.right != null) {
                myQueue.add(temp.right);
            }
        }

    }

    public static void DepthFirstSearch(TreeNode p) {
        if (p == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.println(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRootOfTree;
        TreeNode pre = null;//保存中序遍历的上一个节点

        boolean isFirst = true;

        while (p != null || !stack.isEmpty()) {
            while (p != null) //将节点
            {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            System.out.println(p.val);
            if (isFirst) {
                pRootOfTree = p;
                pre = pRootOfTree;
                isFirst = false;
            } else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }

            p = p.right;
        }
        return pRootOfTree;
    }

    public static void printInZigZagShape(TreeNode p) {
        if (p == null)
            return;

        Stack<TreeNode> stack1 = new Stack<>();//向右栈
        Stack<TreeNode> stack2 = new Stack<>();//向左栈
        stack1.push(p);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    TreeNode temp = stack1.pop();
                    System.out.println(temp.val);
                    if (temp.left != null) {
                        stack2.push(temp.left);
                    }
                    if (temp.right != null) {
                        stack2.push(temp.right);
                    }
                }
            }
            if (!stack2.isEmpty()) {
                while (!stack2.isEmpty()) {
                    TreeNode temp = stack2.pop();
                    System.out.println(temp.val);

                    if (temp.right != null) {
                        stack1.push(temp.right);
                    }
                    if (temp.left != null) {
                        stack1.push(temp.left);
                    }
                }
            }
        }


    }

    private static int ans = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;


        int totalTreeDepth = treeDepth(root.left) + 1 + treeDepth(root.right) + 1;

        return totalTreeDepth - 1;
    }

    private static int treeDepth(TreeNode root) {
        if (root != null) {
            int left = treeDepth(root.left);
            int right = treeDepth(root.right);
            return left > right ? left + 1 : right + 1;
        }
        return 0;
    }

    public static void mirrorTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            mirrorTree(root.left);
        }
        if (root.right != null) {
            mirrorTree(root.right);
        }
    }


    public int minDepth(TreeNode root) {
        if (root == null) return 0;


        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(new Pair<>(root, 1));
        }
        int len = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> tmp = queue.poll();
            TreeNode temp = tmp.getKey();
            len = tmp.getValue();
            if (temp.left == null && temp.right == null) {
                break;
            }

            if (temp.left != null) {
                queue.offer(new Pair<>(temp.left, len + 1));
            }
            if (temp.right != null) {
                queue.offer(new Pair<>(temp.right, len + 1));
            }


        }
        return len;

    }
    public int minDepth2(TreeNode root){
         if (root == null) {
           return 0;
         }

         if ((root.left == null) && (root.right == null)) {
           return 1;
         }

         int min_depth = Integer.MAX_VALUE;
         if (root.left != null) {
           min_depth = Math.min(minDepth2(root.left), min_depth);
         }
         if (root.right != null) {
           min_depth = Math.min(minDepth2(root.right), min_depth);
         }

         return min_depth + 1;
    }


}
