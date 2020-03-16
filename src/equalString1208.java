import java.util.PriorityQueue;

public class equalString1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        //滑动窗口
        int ans = 0;
        int cost = 0;
        int len = s.length();
//        窗口左右界
        int left = 0;
        int right = 0;

        while (right < len) {
            cost += Math.abs(s.charAt(right) - t.charAt(right));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;


    }
}
