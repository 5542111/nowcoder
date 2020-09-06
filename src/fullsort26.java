import java.util.ArrayList;
import java.util.List;

public class fullsort26 {
    public static void main(String[] args) {
        dfs("abcd".toCharArray(), new boolean[4], 0, new ArrayList<>());
        dfs("abc".toCharArray(), new ArrayList<>());
    }

    private final List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        fullsort(nums, 0, nums.length - 1);
        return list;
    }

    public void fullsort(int[] nums, int start, int end) {

        if (start == end) {
            List<Integer> list1 = new ArrayList<>();
            for (int i : nums) {

                list1.add(i);
            }
            list.add(list1);

        }
        for (int i = start; i <= end; i++) {
            swap(nums, i, start);
            fullsort(nums, start + 1, end);
            swap(nums, i, start);
        }


    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void dfs(char[] chars, boolean[] charsUsed, int level, List<Character> list) {
        //截止条件
        if (level == chars.length) {
            System.out.println(list);
            return;
        }
        //筛选节点
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            //筛选
            if (!charsUsed[i]) {
                list.add(temp);
                charsUsed[i] = true;
                dfs(chars, charsUsed, level + 1, list);
                charsUsed[i] = false;
                list.remove(list.size() - 1);
                charsUsed[i] = false;
            }

        }
    }

    public static void dfs(char[] chars, List<Character> list) {
        //截止条件
        if (list.size() == chars.length) {
            System.out.println(list);
            return;
        }
        //筛选节点
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            //筛选
            if (temp != ' ') {
                list.add(temp);
                chars[i] = ' ';
                dfs(chars, list);
                chars[i] = temp;
                list.remove(list.size() - 1);
            }

        }
    }
}
