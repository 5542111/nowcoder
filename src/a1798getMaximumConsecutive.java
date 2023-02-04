import java.util.Arrays;

public class a1798getMaximumConsecutive {
    
    public int getMaximumConsecutive(int[] coins) {
        int x = 0;
        Arrays.sort(coins);
        for (int y : coins) {
            if (y > x + 1) {
                break;
            }
            x += y;
        }
        return x + 1;
    }
}
