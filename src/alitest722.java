import java.util.Arrays;
import java.util.Scanner;

public class alitest722 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        int count=0;
        int[] countNums=new int[n];
        for(int i=0;i<n;i++)
        {
            countNums[nums[i]-1]++;
        }

        System.out.println(Arrays.toString(countNums));
        System.out.println(count);
    }


    public static int countM(int[] arr,int i,int j){
        int count=0;
        for (; i < j; i++) {

        }
        return count;
    }



}
