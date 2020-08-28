import java.util.Arrays;

public class findMedianSortedArrays04 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3};
        int[] arr2 = new int[]{2, 4, 5, 6, 7, 8};
        System.out.println(new findMedianSortedArrays04().findMedianSortedArrays(arr, arr2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] result = new int[len];
        System.arraycopy(nums1, 0, result, 0, nums1.length);
        System.arraycopy(nums2, 0, result, nums1.length, nums2.length);
        Arrays.sort(result);

        if (0 == len % 2) {
            return ((double)result[len / 2] + (double)result[len / 2 - 1]) / 2;
        } else {
            return (double)result[len / 2];
        }
    }

}
