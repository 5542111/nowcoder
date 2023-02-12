public class a1138alphabetBoardPath {
    private static final char[][] board = {
            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'j'},
            {'k', 'l', 'm', 'n', 'o'},
            {'p', 'q', 'r', 's', 't'},
            {'u', 'v', 'w', 'x', 'y'},
            {'z', '0', '1', '2', '3'},
    };

    public static void main(String[] args) {
        System.out.println(new a1138alphabetBoardPath().alphabetBoardPath("asdasdhasjkdhkas"));
    }

    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int row = 0;
        int col = 0;

        for (int i = 0; i < target.length(); i++) {
            int destRow = (target.charAt(i) - 'a') / 5;
            int destCol = (target.charAt(i) - 'a') % 5;
            sb.append(getPath(row, col, destRow,destCol));
            row = destRow;
            col = destCol;
        }
        return sb.toString();
    }

    public String getPath(int fromRow, int fromCol, int destRow,int destCol) {
        StringBuilder sb = new StringBuilder();
        if (destCol < fromCol) {
            for (int k = 0; k < fromCol - destCol; k++) {
                sb.append('L');
            }
        }
        if (destRow < fromRow) {
            for (int k = 0; k < fromRow - destRow; k++) {
                sb.append('U');
            }
        }
        if (destCol > fromCol) {
            for (int k = 0; k < destCol - fromCol; k++) {
                sb.append('R');
            }
        }
        if (destRow > fromRow) {
            for (int k = 0; k < destRow - fromRow; k++) {
                sb.append('D');
            }
        }
        return sb.append('!').toString();
    }
}
