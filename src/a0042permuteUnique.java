import java.util.*;
public class a0042permuteUnique {


    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0) return res;
        Arrays.sort(num);
        permuteUniqueHelper(num, new ArrayList<Integer>(), new boolean[num.length]);
        return res;
    }

    private void permuteUniqueHelper(int[] nums, ArrayList<Integer> temp, boolean[] used) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            temp.add(nums[i]);
            permuteUniqueHelper(nums, temp, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
