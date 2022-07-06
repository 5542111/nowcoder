import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class a0253meetingRooms {
    public static void main(String[] args) {
        int[][] arr =new int[][]{
                {0,30},{15,10},{6,20}
        };
        new a0253meetingRooms().meetingRooms(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }
    }
    public int meetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<Integer> list = new ArrayList<>();
        list.add(intervals[0][1]);
        int res = 1;
        for (int i = 1; i < intervals.length; i++) {
            boolean isNeed = true;
            for (int j = 0; j < list.size(); j++) {
                if (intervals[i][0] >= list.get(j)) {
                    list.set(j, intervals[i][1]);
                    isNeed = false;
                    break;
                }
            }
            if (isNeed) {
                res++;
                list.add(intervals[i][1]);
            }

        }
        return res;
    }
}
