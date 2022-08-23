public class a0782movesToChessboard {


    private int getCnt(int a, int b) {
        return Integer.bitCount(a) != Integer.bitCount(b) ? Integer.MAX_VALUE : Integer.bitCount(a ^ b);
    }

    public int movesToChessboard(int[][] board) {
        int n = board.length;
        int row1 = -1, row2 = -1, col1 = -1, col2 = -1, mask = (1 << n) - 1;

        for (int i = 0; i < n; i++) {
            int a = 0, b = 0;
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) a += (1 << j);
                if (board[j][i] == 1) b += (1 << j);
            }
            if (row1 == -1) row1 = a;
            else if (row2 == -1 && a != row1) row2 = a;
            if (col1 == -1) col1 = b;
            else if (col2 == -1 && b != col1) col2 = b;
            if (a != row1 && a != row2) return -1;
            if (b != col1 && b != col2) return -1;

        }
        if (Integer.bitCount(row1) + Integer.bitCount(row2) != n) return -1;
        if (Integer.bitCount(col1) + Integer.bitCount(col2) != n) return -1;
        if ((row1 ^ row2) != mask || ((col1 ^ col2) != mask)) return -1;
        int temp = 0;
        for (int i = 0; i < n; i += 2) {
            temp += (1 << i);
        }
        int ans = Math.min(getCnt(row1, temp), getCnt(row2, temp)) + Math.min(getCnt(col1, temp), getCnt(col2, temp));

        return ans >= Integer.MAX_VALUE || ans < 0 ? -1 : ans;
    }
}
