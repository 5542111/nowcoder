import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class alitest {
    //    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//
//        int[] arr = new int[n];
//        int i = 0;
//        while (i < n) {
//            arr[i] = input.nextInt();
//            i++;
//        }
//        int ans = 0;
//        int start=0;
//        while (true) {
//            if (arr[start%arr.length]>0) {
//
//                ans++;
//                arr[start%arr.length]--;
//                for (int x:arr)
//                {
//                    System.out.print(x);
//                }
//                System.out.println("------"+ans);
//                start++;
//
//            }else break;
//        }
//        System.out.println(ans);
//    }
    public static void main(String[] args) {
        Object o=new Object();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        new alitest().premute(nums, 0);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void premute(int[] arr, int start) {
        if (arr.length == start && judge(arr)) {
            System.out.println(Arrays.toString(arr));
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            premute(arr, start + 1);
            swap(arr, start, i);
        }
    }

    private boolean judge(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) == 1) {
                return false;
            }
        }
        return true;
    }
}
