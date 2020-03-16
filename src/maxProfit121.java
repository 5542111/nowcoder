import java.util.LinkedList;
import java.util.Queue;

public class maxProfit121 {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public int maxProfit1(int prices[]) {
            int max=0;
            for (int i=1;i<prices.length;i++)
            {
                int temp=prices[i]-prices[i-1];
                if (temp>0)
                {
                    max+=temp;
                }


            }

            return max;
    }

}
