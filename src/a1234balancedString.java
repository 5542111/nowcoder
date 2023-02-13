import java.lang.reflect.Array;
import java.util.Arrays;

public class a1234balancedString {
    public static void main(String[] args) {
        System.out.println(new a1234balancedString().balancedString("WWEQERQWQWWRWWERQWEQ"));
    }

    public int balancedString(String s) {
        int interval = s.length() / 4;
        int[] count = new int[4];
        for (char c : s.toCharArray()) {
            if (c == 'Q') {
                count[0]++;
            } else if (c == 'W') {
                count[1]++;
            } else if (c == 'E') {
                count[2]++;
            } else {
                count[3]++;
            }
        }
        if (count[0] == interval && count[1] == interval && count[2] == interval && count[3] == interval) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            count[getIndex(s.charAt(right))]--;
            while (left <= right && count[0] <= interval && count[1] <= interval && count[2] <= interval && count[3] <= interval) {
                ans = Math.min(ans, right - left + 1);
                count[getIndex(s.charAt(left))]++;
                left++;
            }
            right++;
        }
        return ans;
    }

    private int getIndex(char c) {
        if (c == 'Q') {
            return 0;
        } else if (c == 'W') {
            return 1;
        } else if (c == 'E') {
            return 2;
        } else {
            return 3;
        }
    }
}
