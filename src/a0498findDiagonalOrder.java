public class a0498findDiagonalOrder {

    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[] res = new int[row * col];
        int[] dx = {-1, 1}, dy = {1, -1};
        int d = 1;
        int x = 0, y = 0;
        boolean[][] matUsed = new boolean[row][col];
        for (int i = 0; i < row * col; i++) {
            if (x >= row || y >= col) return res;
            res[i] = mat[x][y];
            matUsed[x][y] = true;
            int a = x + dx[d], b = y + dy[d];
            System.out.print(a + " " + b);
            if (a < 0 || a >= row || b < 0 || b >= col || matUsed[a][b]) {
                d = (d + 1) % 2;
                if (a < 0) {
                    if (b >= col) {
                        a = x + 1;
                        b = y;
                    } else {
                        a = x;
                    }

                } else if (b < 0) {
                    if (a >= row) {
                        a = x;
                        b = y + 1;
                    } else {
                        b = y;
                    }
                } else if (a >= row) {
                    a = x;
                    b = y + 1;
                } else {
                    b = y;
                    a = x + 1;
                }
            }
            x = a;
            y = b;
            System.out.println(x + " " + y);

        }
        return res;
    }
}
