public class computeArea223 {
    public static void main(String[] args) {
        System.out.println(new computeArea223().computeArea(-2, -2, 2, 2, 1, 1, 3, 3));
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int length1 = C - A, width1 = D - B;
        //System.out.println(length1+ " "+ width1);
        int length2 = G - E, width2 = H - F;
        //System.out.println(length2+ " "+ width2);
        int totalArea = length1 * width1 + length2 * width2;
        int coverArea = 0;
        if (!(E >= C || G <= A || F >= D || H <= B)) {
            int coverLength = Math.min(D, H) - Math.max(B, F), coverWidth = Math.min(C, G) - Math.max(A, E);
            //System.out.println(coverLength+" "+ coverWidth);
            coverArea = coverLength * coverWidth;
        }


        return totalArea - coverArea;

    }
}
