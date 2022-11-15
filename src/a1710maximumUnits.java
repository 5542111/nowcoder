import java.util.Arrays;
public class a1710maximumUnits {
    public static void main(String[] args) {
        System.out.println(new a1710maximumUnits().maximumUnits(new int[][]{
                {5, 10}, {2, 5}, {4, 7}, {3, 9}
        }, 10));
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(o1, o2) -> o2[1] - o1[1]);
        int count = 0;
        for (int[] boxType : boxTypes) {
            if (truckSize == 0) {
                break;
            }
            int num = boxType[0];
            int size = boxType[1];
            if (num < truckSize) {
                count += num * size;
                truckSize -= num;
            } else {
                count += truckSize * size;
                truckSize = 0;
            }


        }
        return count;
    }
}
