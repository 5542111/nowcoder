import java.util.Arrays;

public class a1606smallestDifference {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;

        long min = Integer.MAX_VALUE;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) return 0;
            else if (a[i] > b[j]) {
                min = Math.min(min, (long)a[i] - (long)b[j]);
                j++;
            } else {
                min = Math.min(min, (long)b[j] - (long)a[i]);
                i++;
            }
        }


        return (int)min;
    }
}
