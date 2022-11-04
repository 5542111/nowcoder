public class a0754reachNumber {

    int minStep = Integer.MAX_VALUE;


    public static void main(String[] args) {
        System.out.println(new a0754reachNumber().reachNumber(3));
    }
    public int reachNumber(int target) {
        if (target < 0) target = -target;
        int k = (int) Math.sqrt(2 * target), dist = k * (k + 1) / 2;
        while (dist < target || (dist - target) % 2 == 1) {
            k++;
            dist = k * (k + 1) / 2;
        }
        return k;

    }

}
