public class alphabetBoardPath1138 {

    public String alphabetBoardPath(String target) {

        StringBuffer sb = new StringBuffer();
        int row = 0;
        int col = 0;
        for (char c : target.toCharArray()) {
            int x = (c - 'a') / 5, y = (c - 'a') % 5;

            if (y < col) {
                for (int i = 0; i < col - y; i++) {
                    sb.append('L');
                }
            }
            if (x < row ) {
                for (int i = 0; i < row - x; i++) {
                    sb.append('U');
                }
            }
            if (y > col) {
                for (int i = 0; i < y- col; i++) {
                    sb.append('R');
                }
            }
            if (x > row) {
                for (int i = 0; i < x-row; i++) {
                    sb.append('D');
                }
            }

            sb.append('!');

            row = x;
            col = y;


        }

        return sb.toString();

    }
}
