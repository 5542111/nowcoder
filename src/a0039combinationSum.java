import java.util.*;

public class a0039combinationSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new a0039combinationSum().combinationSum(arr, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumHelper2(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void combinationSumHelper(int[] candidates, int target, Set<List<Integer>> res, List<Integer> path) {
        if (sum(path) > target) return;
        if (sum(path) == target) {
            Collections.sort(path);
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            path.add(candidates[i]);
            combinationSumHelper(candidates, target, res, path);
            path.remove(path.size() - 1);
        }
    }

    private int sum(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }

    private void combinationSumHelper2(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int index) {
        if (index == candidates.length) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        combinationSumHelper2(candidates, target, res, path, index + 1);
        if (target < candidates[index]) return;
        path.add(candidates[index]);
        combinationSumHelper2(candidates, target - candidates[index], res, path, index);
        path.remove(path.size() - 1);

    }
}
