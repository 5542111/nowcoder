import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a0051solveNQueens {
    public static void main(String[] args) {
        System.out.println(new a0051solveNQueens().solveNQueens(9));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        dfs(board, 0, res, n);
        return res;
    }

    public void dfs(char[][] board, int row, List<List<String>> res, int n) {
        if (row == board.length) {
            List<String> temp = new ArrayList<>();
            for (char[] chars : board) {
                temp.add(new String(chars));
            }
            res.add(temp);
            return;
        }
        //这是行上的遍历
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col, n)) {
                continue;
            }
            board[row][col] = 'Q';
            dfs(board, row + 1, res, n);
            board[row][col] = '.';
        }


    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        //检查当前列是否有放置Q
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') return false;
        }
        //检测 右上方 是否有放置Q
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        //检测 左上方 是否有放置Q
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
