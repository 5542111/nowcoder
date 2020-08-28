import java.util.ArrayList;
import java.util.Arrays;

public class primeCount {
    public static void main(String[] args) {
        System.out.println(primeCountSum(new int[]{3, 5, 7}));
        minSeq(new int[]{3, 1, 7}, 3, 6);
    }

    private static long primeCountSum(int[] nums) {
        long sum = 0;
        for (int i :
                nums) {
            sum += dividePrimeCount(i);
        }
        return sum;
    }

    private static long dividePrimeCount(int num) {
        long res = 0;
        while (num != 1 && num != 0) {
            res++;
            num -= 2;
        }
        return res;
    }

    private static int[] minSeq(int[] nums, int n, int m) {
        int[] res=new int[m];
        ArrayList<Integer> listN = new ArrayList<>();
        ArrayList<Integer> listM = new ArrayList<>();
        for (int i :
                nums) {
            listN.add(i);

        }
        System.out.println(listN.toString());
        for (int i = 0; i < n; i++) {

            for (int j = 1; j <nums[i]; j++) {
                if (!listN.contains(j)) {
                    listM.add(j);
                    listN.add(j);
                }
            }
            listM.add(nums[i]);
        }
        if (listM.size()<m){
            int end=listM.get(listM.size()-1);
            while (end<m){
                listM.add(++end);
            }
        }
        System.out.println(listM.toString());
        for (int i = 0; i <m ; i++) {
            res[i]=listM.get(i);
        }
        return res;
    }
}
