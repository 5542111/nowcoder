public class a0941validMountainArray {
    /**
     *
     * 双指针 向中间加逼 也可以
     *
     * @param arr
     * @return
     */
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int i = 0;
        while (i + 1 < arr.length && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0 || i == arr.length - 1) {
            return false;
        }

        while (i + 1 < arr.length && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == arr.length - 1;
    }
}
