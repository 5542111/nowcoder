import java.util.*;
import java.util.stream.Collectors;

public class a2248intersection {

    public List<Integer> intersection(int[][] nums) {

        Set<Integer> first = toSet(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            Set<Integer> integers = new HashSet<>();
            for (int j = 0; j < nums[i].length; j++) {
                if (first.contains(nums[i][j])) {
                    integers.add(nums[i][j]);
                }
            }
            first = integers;
        }
        List<Integer> res = new ArrayList<>(first);
        Collections.sort(res);
        return res;
    }

    private Set<Integer> toSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        return set;
    }

    public List<Integer> intersection2(int[][] nums) {
        int[] count = new int[1000];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                count[nums[i][j]]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == nums.length) {
                res.add(i);
            }
        }
        return res;
    }

}
