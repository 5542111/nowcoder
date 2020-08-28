import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.bcel.internal.generic.INEG;
import com.sun.security.sasl.ClientFactoryImpl;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class insert57 {
    public static void main(String[] args) {
        //[[1,3],[6,9]]
        //[2,5]

        //[[1,2],[3,5],[6,7],[8,10],[12,16]]
        //[17,19]
        int[][] intervals = new int[][]{
                {1, 2},
                {3, 5},
                {6, 7},
                {12, 16},

        };
        int[] newInterval = new int[]{
                17, 19
        };
        int[][] res = insert(intervals, newInterval);
        for (int[] arr : res) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
      

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0 || intervals == null) {
            return new int[][]{newInterval};
        }
        List<int[]> list = new ArrayList<>();
        for (int[] arr : intervals) {
            list.add(arr);
        }
        list.add(newInterval);
        int[][] res = list.toArray(new int[list.size()][]);
        return merge(res);
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        //按左端点排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));


        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curArr = intervals[i];

            int[] peek = list.get(list.size() - 1);
            if (curArr[0] > peek[1]) {
                list.add(curArr);
            } else {
                peek[1] = Math.max(curArr[1], peek[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }


}
