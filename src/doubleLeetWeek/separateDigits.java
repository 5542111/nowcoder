package doubleLeetWeek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class separateDigits {

    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            ans.addAll(splitNum(num));
        }
        int[] res= new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;

    }

    private List<Integer> splitNum(int num) {
        List<Integer> temp = new ArrayList<>();
        while (num > 0) {
            temp.add(num % 10);
            num /= 10;
        }
        Collections.reverse(temp);
        return temp;
    }
}
