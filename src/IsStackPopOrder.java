
import java.util.Arrays;
import java.util.Stack;

public class IsStackPopOrder {
    public static void main(String[] args) {

    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        int[] arr = sequence.clone();
        Arrays.sort(arr);
        return IsPopOrder(arr, sequence);

    }
    /**
     * 入栈1,2,3,4,5
     * <p>
     * 出栈4,5,3,2,1
     * <p>
     * 首先1入辅助栈，此时栈顶1≠4，继续入栈2
     * <p>
     * 此时栈顶2≠4，继续入栈3
     * <p>
     * 此时栈顶3≠4，继续入栈4
     * <p>
     * 此时栈顶4＝4，出栈4，弹出序列向后一位，此时为5，,辅助栈里面是1,2,3
     * <p>
     * 此时栈顶3≠5，继续入栈5
     * <p>
     * 此时栈顶5=5，出栈5,弹出序列向后一位，此时为3，,辅助栈里面是1,2,3
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (popA.length != pushA.length) {
            return false;
        }
        Stack<Integer> push = new Stack<>();
        int popAIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            push.push(pushA[i]);
            while ( !push.empty()&&push.peek() == popA[popAIndex]) {
                popAIndex++;
                push.pop();
            }
        }

        return push.empty();
    }
}
