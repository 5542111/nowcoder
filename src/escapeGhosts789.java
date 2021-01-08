public class escapeGhosts789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] source = new int[]{0, 0};

        for (int[] ghost : ghosts) {
            if (manhattanDistance(ghost, target) <= manhattanDistance(source, target)) {
                return false;
            }
        }
        return true;

    }

    public int manhattanDistance(int[] source, int[] target) {
        return Math.abs(source[0] - target[0]) + Math.abs(source[1] - target[1]);
    }
}
