public class a0258addDigits {
    public int addDigits(int num) {
        String temp = String.valueOf(num);
        while (temp.length() > 1) {
            int sum = 0;
            for (int i = 0; i < temp.length(); i++) {
                sum += temp.charAt(i) - '0';
            }
            temp = String.valueOf(sum);
        }
        return Integer.parseInt(temp);
    }
}
