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
        Scanner scan = new Scanner(System.in);
        String aStr = scan.nextLine();
        String bStr = scan.nextLine();
        int aLen = aStr.length();
        int bLen = bStr.length();
        int[][] dp = new int[aLen + 1][bLen + 1];
        for (int i = 0; i < aLen + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < bLen + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < aLen + 1; i++) {
            for (int j = 1; j < bLen + 1; j++) {
                if (aStr.charAt(i - 1) == bStr.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        for (int i = 0; i < aLen + 1; i++) {
            for (int i1 = 0; i1 < bLen + 1; i1++) {
                System.out.print(dp[i][i1]);
            }
            System.out.println();
        }
        System.out.println(dp[aLen][bLen]);
    }
}
