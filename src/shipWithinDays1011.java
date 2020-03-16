import java.util.Map;

public class shipWithinDays1011 {
    public int shipWithinDays(int[] weights, int D) {

        int sum = 0;
        int max = 0;
        for (int weight : weights) {
            sum += weight;
            if (weight > max) {
                max = weight;
            }
        }

        int index = Math.max(max, sum / D);
        boolean flag = true;
        while (flag) {
            int tempWeight = 0;
            int dCount = 0;

            for (int i = 0; i < weights.length; i++) {
                tempWeight += weights[i];
                if (tempWeight > index ) {
                    //System.out.print(tempWeight-weights[i]+" ");
                    tempWeight = weights[i];
                    dCount++;

                }
                if (tempWeight>0&&dCount>=D)
                {
                    dCount++;
                }

            }
                System.out.println(dCount);
            if (dCount > D) {
                index++;
            } else if (dCount < D) {
                index--;
            } else {
                flag = false;
            }


        }

        return index;
    }


}
