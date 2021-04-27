import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class sort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 3, 4, 1, 3, 8, 9, 1};
        new sort().fastSort(arr,0,arr.length-1);
        System.out.println();
        Map<Integer,Integer> hs=new HashMap<>();

//
//        new sort().quicksort(arr, 0, arr.length-1);
//        for (Integer i :
//                arr) {
//            System.out.print(i + " ");
//        }
    }

    public void quicksort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }

        int left = partitionSort(arr, L, R);
        quicksort(arr, L, left - 1);
        quicksort(arr, left + 1, R);
    }

    public void fastSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            if (left < right) {
                int midPos = partitionSort(arr, left, right);
                if (left < midPos - 1) {
                    stack.push(left);
                    stack.push(midPos - 1);
                }
                if (midPos + 1 < right) {
                    stack.push(midPos + 1);
                    stack.push(right);
                }
            }
        }
        for (Integer i :
                arr) {
            System.out.print(i + " ");
        }
    }

    private int partitionSort(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;

        return left;
    }

    private int findKByQuickSort(int[] arr, int L, int R, int k) {
        if (L == R)
            return arr[L];

        int left = partitionSort(arr, L, R);
        if (k <= left - L) return findKByQuickSort(arr, L, left - 1, k);
        else if (k == left - L + 1) return findKByQuickSort(arr, left, left, k);
        else return findKByQuickSort(arr, left + 1, R, k - (left - L + 1));


    }

    private int findKBigByQuickSort(int[] arr, int L, int R, int k) {
        if (L == R)
            return arr[L];

        int left = partitionSort(arr, L, R);
        if (k <= R - left) return findKBigByQuickSort(arr, left + 1, R, k);
        else if (k == R - left + 1) return arr[left];
        else return findKBigByQuickSort(arr, L, left - 1, k - (R - left + 1));


    }
}
