public class robotLCP03 {
    public static void main(String[] args) {
        System.out.println(new robotLCP03().robot("RUUR", new int[][]{{10, 5}, {1, 6}, {6, 10}, {3, 0}, {0, 3}, {0, 10}, {6, 2}}, 7856, 9033));
    }

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int[] loc = new int[]{0, 0};
        int len = command.length();
        int step = 0;

        while (loc[0] != x || loc[1] != y) {
            if (loc[0] > x || loc[1] > y) {
                return false;
            }
            for (int[] obstacle : obstacles) {
                if (obstacle[0] == loc[0] && obstacle[1] == loc[1]) {
                    return false;
                }
            }
            if (command.charAt(step % len) == 'U') {
                loc[1]++;
            } else {
                loc[0]++;
            }
            step++;
            System.out.println(loc[0] + " " + loc[1]);
        }


        if (loc[0] == x && loc[1] == y) {
            return true;
        }


        return false;
    }

    public boolean robot2(String command, int[][] obstacles, int x, int y) {
        int upCnt = 0, rightCnt = 0;
        for (char ch : command.toCharArray()) {
            if (ch == 'U')
                upCnt++;
            else
                rightCnt++;
        }
        if (!canReach(upCnt, rightCnt, command, x, y))
            return false;


        for (int[] obstacle : obstacles) {
            if (obstacle[0] <= x && obstacle[1] <= y && canReach(upCnt, rightCnt, command, obstacle[0], obstacle[1]))
                return false;
        }
        return true;
    }

    private boolean canReach(int upCnt, int rightCnt, String command, int destX, int destY) {
        int loopCnt = Math.min(destX / rightCnt, destY / upCnt);

        destX -= loopCnt * rightCnt;
        destY -= loopCnt * upCnt;

        for (char ch : command.toCharArray()) {
            if (destX == 0 && destY == 0)
                return true;
            if (ch == 'U')
                destY--;
            else
                destX--;
        }

        return destX == 0 && destY == 0;
    }

}
