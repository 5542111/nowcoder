public class addStrings415 {
    public static void main(String[] args) {
        System.out.println(addStrings("10000000", "999999999999"));
        System.out.println(multiStrings("1111","111"));
        int i=0;
        i++;
        i=i++;
        System.out.println(i);
        System.out.println("123".intern()=="123");
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

    public static String multiStrings(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }
}
