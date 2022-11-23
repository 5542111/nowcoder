
public class a1742countBalls {


    public int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[46];
        int max = 0;
        for (int i = lowLimit; i < highLimit + 1; i++) {
            int valueBox = getValueBox(i);
            count[valueBox]++;
            max = Math.max(max, count[valueBox]);
        }
        return max;
    }

    private int getValueBox(int value) {
        int count = 0;
        while (value > 0) {
            count += value % 10;
            value = value / 10;
        }

        return count;
    }
}
