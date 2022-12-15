public class a1945getLucky {

    public static void main(String[] args) {
        System.out.println(new a1945getLucky().getLucky("zbax", 2));
    }

    public int getLucky(String s, int k) {
        StringBuilder numStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            numStr.append(c - 'a' + 1);
        }
        while (k > 0) {
            int res = 0;
            for (char c : numStr.toString().toCharArray()) {
                res += c - '0';
            }
            System.out.println(numStr);
            numStr = new StringBuilder(String.valueOf(res));
            k--;
        }

        return Integer.parseInt(numStr.toString());
    }
}
