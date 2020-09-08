import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class validSquare593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<Integer> list = new ArrayList<>();
        list.add(length(p1, p2));
        list.add(length(p1, p3));
        list.add(length(p1, p4));
        list.add(length(p3, p2));
        list.add(length(p4, p2));
        list.add(length(p3, p4));
        Collections.sort(list);
        int temp = list.get(0);
        int sum = 0;
        int tmp = list.get(list.size() - 1);
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (list.get(i) == temp) sum++;
            if (list.get(i) == tmp) count++;
        }
        if (sum == 4 && count == 2 && temp * 2 == tmp) {
            return true;
        }
        return false;
    }

    private int length(int[] p, int[] q) {
        return (int) Math.pow(p[0] - q[0], 2) + (int) Math.pow(p[1] - q[1], 2);
    }
}
