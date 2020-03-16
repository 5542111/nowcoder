import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class Solution03 {
    public static void main(String[] args) {

    }
//    public ArrayList<Integer> printListFromTailoHead(ListNode listNode) {
//        ArrayList<Integer> list=new ArrayList<>();
//        while(listNode!=null)
//        {
//            list.add(listNode.val);
//            listNode=listNode.next;
//        }
//        ArrayList<Integer> list1=new ArrayList<>();
//        for (int i=list.size()-1;i>=0;i--)
//        {
//            list1.add(list.get(i));
//        }
//        return list1;
//    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int temp = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return temp;
    }


    public int minNumberInRotateArray(int [] array) {
        if (array.length==0)
        {
            return 0;
        }
        Arrays.sort(array);
        return array[0];
    }
}
