public class a1758minOperations {
    public static void main(String[] args) {
        System.out.println(new a1758minOperations().minOperations("101"));
    }

    public int minOperations(String s) {
        int count = 0;
        char c = '0';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                count++;
            }
            c = getReverse(c);
        }
        return Math.min(s.length()-count, count);
    }

    private char getReverse(char c) {
        if (c == '0') return '1';
        else return '0';
    }
}
