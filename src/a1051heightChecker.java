import java.util.Arrays;

public class a1051heightChecker {
    public int heightChecker(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        // int[] expected = new int[heights.length];
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        int res = 0;
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != heights[i]) res++;
        }
        return res;
    }

    public int heightChecker2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int[] count = new int[101];
        for (int i = 0; i < heights.length; i++) {
            count[heights[i]]++;
        }
        int index = 0, res = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j <= count[i]; j++) {
                if (heights[index] != i) {
                    res++;
                }
                index++;
            }
        }
        return res;
    }
}
