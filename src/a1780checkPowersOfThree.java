public class a1780checkPowersOfThree {
    public static void main(String[] args) {
        System.out.println(new a1780checkPowersOfThree().checkPowersOfThree(10000000));
    }

    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }


}
