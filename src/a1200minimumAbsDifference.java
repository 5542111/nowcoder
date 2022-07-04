import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a1200minimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i + 1] - arr[i];
            if (temp < min) {
                res.clear();
                min = temp;
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (temp == min) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return res;
    }
}
