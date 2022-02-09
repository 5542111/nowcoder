import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a0040combinationSum2 {
    public static void main(String[] args) {
        System.out.println(new a0040combinationSum2().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        // dfs(candidates, target, res, new ArrayList<>(), 0, 0);
        dfs(candidates, target, res, new ArrayList<>(), 0);

        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int sum, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) return;
            temp.add(candidates[i]);
            dfs(candidates, target, res, temp, sum + candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int index) {
        if (0 == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) return;
            temp.add(candidates[i]);
            dfs(candidates, target - candidates[i], res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
