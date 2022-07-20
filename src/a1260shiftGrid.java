import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class a1260shiftGrid {
    public static void main(String[] args) {
        new a1260shiftGrid().shiftGrid(new int[][]{
                {1},
                {2},
                {3},
                {4},
                {7},
                {6},
                {5}
        }, 23);
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            List<Integer> rows = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                rows.add(0);
            }
            res.add(rows);
        }
        int total = row * col;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int index = (i * col + j + k) % total;
                res.get(index / col).set(index % col, grid[i][j]);
            }
        }
        System.out.println(res);
        return res;
    }
}
