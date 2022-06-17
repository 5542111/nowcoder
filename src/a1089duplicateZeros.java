import java.util.ArrayList;
import java.util.List;

public class a1089duplicateZeros {
    public void duplicateZeros(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for (int j : arr) {
            ans.add(j);
            if (j == 0) {
                ans.add(j);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans.get(i);
        }

    }
}
