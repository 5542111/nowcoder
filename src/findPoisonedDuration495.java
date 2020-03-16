public class findPoisonedDuration495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        if (timeSeries.length == 1) return duration;

        int sum = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i]-timeSeries[i-1]<=duration)
            {
                sum+=duration-(timeSeries[i]-timeSeries[i-1]);
            }
            else sum+=duration;

            System.out.println(sum);
        }

        return sum;
    }
}
