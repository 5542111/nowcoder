import java.util.ArrayList;
import java.util.List;

public class fullsort26 {
    private final List<List<Integer>> list= new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        fullsort(nums,0,nums.length-1);
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
        for (int i=start;i<=end;i++)
        {
            swap(nums,i,start);
            fullsort(nums,start+1,end);
            swap(nums,i,start);
        }


    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
