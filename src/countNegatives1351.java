/**
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 */
public class countNegatives1351 {

    public int countNegatives(int[][] grid) {
        //矩阵的行数和列数
        int row = grid.length;//
        int column = grid[0].length;

        //当前数在第几列
        int rowIndex = 0;

        //负数的个数总和
        int sum = 0;

        for(int i = row - 1; i >= 0; i--)
        {
            //找到该行第一个负数所在的列数
            //这个while循环最多循环column次（rowIndex 从0 到 column - 1）
            while(rowIndex < column && grid[i][rowIndex] >= 0)
            {
                rowIndex ++;
            }
            //该行没负数，直接return
            if(rowIndex == column)
            {
                return sum;
            }
            //该行还有负数，加上
            sum += (column - rowIndex);
        }

        return sum;
    }
}
