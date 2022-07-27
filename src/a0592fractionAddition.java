public class a0592fractionAddition {
    public static void main(String[] args) {
        System.out.println(new a0592fractionAddition().fractionAddition("-4/7-3/4+2/3"));
    }

    public String fractionAddition(String expression) {
        long topSum = 0;
        long bottomSum = 1;
        int index = 0;
        while (index < expression.length()) {
            boolean flag = expression.charAt(index) == '-';
            int j = index;
            if (flag) {
                j++;
            } else {
                if (expression.charAt(index) == '+') {
                    j++;
                }
            }
            StringBuilder top = new StringBuilder();
            while (j < expression.length() && Character.isDigit(expression.charAt(j))) {
                top.append(expression.charAt(j));
                j++;
            }
            long topValue = flag ? -Long.parseLong(top.toString()) : Long.parseLong(top.toString());
            StringBuilder bottom = new StringBuilder();
            j++;
            while (j < expression.length() && Character.isDigit(expression.charAt(j))) {
                bottom.append(expression.charAt(j));
                j++;
            }
            long bottomValue = Long.parseLong(bottom.toString());
            index = j;
            topSum = topSum * bottomValue + bottomSum * topValue;
            bottomSum *= bottomValue;
        }
        if (topSum == 0) {
            return "0/1";
        }
        long gcd = gcd(Math.abs(topSum), bottomSum);
        return topSum/gcd +"/" + bottomSum/gcd;
    }

    private long gcd(long a, long b) {
        return  b == 0 ? a : gcd(b, a % b);
    }
}
