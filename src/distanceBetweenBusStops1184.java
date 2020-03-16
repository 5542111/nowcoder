public class distanceBetweenBusStops1184 {
    public static void main(String[] args) {
        int[] ps={7,10,1,12,11,14,5,0};
        System.out.println(distanceBetweenBusStops(ps, 7, 2));
    }
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        System.out.println(start+" "+destination);
        if (start > destination) {
            return distanceBetweenBusStops(distance,destination,start);

        }

        int posDirect = 0;
        int negDirect = 0;
        for (int i = start; i < destination; i++) {
            posDirect += distance[i];
        }
        System.out.println(posDirect);
        for (int i = destination; i < distance.length+start; i++) {
            negDirect += distance[i % distance.length];
            //System.out.println(negDirect);
        }
        System.out.println(negDirect);


        return Math.min(posDirect, negDirect);


    }
}
