import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a0593validSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<Integer> list = new ArrayList<>();
        list.add(getDistance(p1, p2));
        list.add(getDistance(p1, p3));
        list.add(getDistance(p1, p4));
        list.add(getDistance(p2, p3));
        list.add(getDistance(p2, p4));
        list.add(getDistance(p3, p4));
        Collections.sort(list);
        System.out.println(list);
        int edge = list.get(0);
        int edgeSum = 0;
        int toAngle = list.get(list.size() - 1);
        int toAngleSum = 0;
        if (edge * 2 != toAngleSum) return false;
        for (Integer len : list) {
            if (len == edge) edgeSum++;
            if (len == toAngle) toAngleSum++;
        }
        return edgeSum == 4 && toAngleSum == 2;
    }

    private int getDistance(int[] p1, int[] p2) {
        return (int) (Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[2], 2));
    }
}
