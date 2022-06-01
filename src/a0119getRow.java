import java.util.ArrayList;
import java.util.List;

public class a0119getRow {
    public static void main(String[] args) {
        System.out.println(new a0119getRow().getRow(3));
    }
    public List<Integer> getRow(int rowIndex) {
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        for (int i = 0; i < rowIndex + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < rowIndex+1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i-1][j];
            }
        }
        List<Integer> ans = new ArrayList<>();
        int[] res = dp[rowIndex];
        for (int i = 0; i < res.length; i++) {
            ans.add(res[i]);
        }
        return ans;
    }
}
