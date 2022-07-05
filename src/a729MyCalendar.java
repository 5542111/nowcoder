import java.util.ArrayList;
import java.util.List;

public class a729MyCalendar {
    List<int[]> list;

    public a729MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] interval : list) {
            if (interval[0]<end && start<interval[1]) return false;
        }
        list.add(new int[]{start, end});
        return true;
    }
}
