package doubleLeetWeek;

public class maximizeWin {
    public static void main(String[] args) {
        System.out.println(new maximizeWin().maximizeWin(new int[]{1, 1, 2, 2, 3, 3, 5}, 2));
    }

    public int maximizeWin(int[] prizePositions, int k) {
        //代表当前节点 prize[i] 左侧最多覆盖多少个节点 用 pre[i+1]表示
        int[] pre = new int[prizePositions.length + 1];
        int left = 0;
        int right = 0;
        int ans = 0;

        while (right < prizePositions.length) {
            while (prizePositions[right] - prizePositions[left] > k) {
                left++;
            }
            ans = Math.max(ans, right - left + 1 + pre[left]);
            pre[right + 1] = Math.max(pre[right], right - left + 1);
            right++;
        }

        return ans;

    }
}
