import java.util.ArrayList;
import java.util.List;

public class subsets78 {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] numsUsed = new boolean[nums.length];
        dfs(nums, numsUsed, 0, nums.length, new ArrayList<>(), res);
        return res;


    }

    private void dfs(int[] nums, boolean[] numsUsed, int index, int n, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() > n) return;

        res.add(new ArrayList<>(temp));
        System.out.println(temp+" "+ index);

        for (int i = index; i < n; i++) {
            if (!numsUsed[i]){
                temp.add(nums[i]);
                numsUsed[i] = true;
                dfs(nums, numsUsed, index + 1, n, temp, res);
                numsUsed[i] = false;
                temp.remove(temp.size()-1);
            }else {
                return;
            }

        }

    }
}
