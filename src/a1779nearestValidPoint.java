public class a1779nearestValidPoint {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int abs = Math.abs(y - points[i][1]) + Math.abs(x - points[i][0]);
                if (abs < min) {
                    min = abs;
                    index = i;
                }

            }
        }
        return index;
    }
}
