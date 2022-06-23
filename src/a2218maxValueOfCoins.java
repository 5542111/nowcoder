import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class a2218maxValueOfCoins {

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {


        int[][] dp = new int[piles.size() + 1][k + 1];
        //base case 本身就是 0 不需要 处理base case了
        for (int i = 1; i < piles.size() + 1; i++) {
            List<Integer> pile = piles.get(i - 1);
            for (int j = 1; j < k + 1; j++) {
                int sum = 0; //前缀和
                //每组数据 不能超过 j
                for (int l = 0; l < pile.size() + 1 && l <= j; l++) {
                    dp[i][j] = Math.max(sum + dp[i - 1][j - l], dp[i][j]);
                    //这里统计前缀和 要注意越界
                    if (l < pile.size()){
                        sum+= pile.get(l);
                    }
                }
            }
        }


        return dp[piles.size()][k];
    }

}
