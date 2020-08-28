import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashSet;
import java.util.Set;

public class duplateNum {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3,  5,};
        System.out.println(new duplateNum().duplateNumOfN2(nums));
    }

    public int duplateNumOfN(int[] arr) {
        //空间复杂度O(1)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] ^ arr[j]) == 0) {
                    return arr[i];
                }
            }
        }
        return -1;
    }
    public int duplateNumOfN2(int[] arr) {
        //时间复杂度o(n) 空间o(n）
        Set<Integer> set=new HashSet<>();
        for (Integer i:arr){
            if (set.contains(i)){
                return i;
            }
            set.add(i);
        }
        return -1;
    }
}
