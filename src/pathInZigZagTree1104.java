import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pathInZigZagTree1104 {
    public static void main(String[] args) {
        System.out.println(new pathInZigZagTree1104().pathInZigZagTree(15));
    }
    public List<Integer> pathInZigZagTree(int label) {
        ArrayList<Integer> integers = new ArrayList<>();//0.初始化存放结果的变量
        int a = (int) (Math.log(label) / Math.log(2));//2.计算label所在的层
        while (label > 1) {//5.循环直到遇到特殊情况1
            integers.add(label);//3.将label的结果添加到数组中
            label = (int) (3 * Math.pow(2, --a) - label / 2 - 1);//4.计算下一个label的值
        }
        integers.add(1);//6.添加特殊情况 1
        Collections.reverse(integers); //7.翻转数组
        return integers;//1.返回结果


    }


}
