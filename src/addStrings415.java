public class addStrings415 {
    public static void main(String[] args) {
        System.out.println(addStrings("10000000", "999999999999"));
    }

    public static String addStrings(String num1, String num2) {
        int sum = 0;
        int carry = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        while (len1 >= 0 || len2 >= 0) {
            int x = (len1 >= 0 ? num1.charAt(len1) - '0' : 0);
            int y = (len2 >= 0 ? num2.charAt(len2) - '0' : 0);

            sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            stringBuffer.append(sum);
            len1--;
            len2--;
        }
        if (carry == 1) stringBuffer.append(carry);
        return stringBuffer.reverse().toString();
    }
}
