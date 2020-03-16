import java.util.ArrayList;

public class ClockwisePrintMatrix {
    public static void main(String[] args) {

        int[][] arr={{1,2},{2,3},{4,4},{6,6}};
        ArrayList<Integer> list=printMatrix(arr);

        for (Integer  integer:list){
            System.out.println(integer);
        }

    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length == 0)
            return list;
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                list.add(matrix[0][i]);
            }
            return list;


        }

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            //left to right
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            //top to bottom
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            //right to left
            if (top != bottom) {
                for (int i = right - 1; i >=left; i--) {
                    list.add(matrix[bottom][i]);
                }
            }
            //bottom to top
            if ( left!=right) {
                for (int i = bottom - 1; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }


        return list;

    }
}
