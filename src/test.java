import java.util.Arrays;
import java.util.Scanner;

public class test {
    //    public static void main(String[] args) {
//        sortAlgorithm sortAlgorithm=new sortAlgorithm();
//        int [] arr={7,41,2,34,4,6,100};
//        System.out.println(Arrays.toString(arr));
//        sortAlgorithm.fastSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
//    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
