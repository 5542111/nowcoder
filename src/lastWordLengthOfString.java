import java.util.Scanner;

public class lastWordLengthOfString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String str = input.next();
        char ch = str.charAt(0);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch||s.charAt(i)-' '==ch||ch-' '==s.charAt(i)) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    private static int TheLastWordLengthOfString(String s) {
        s = s.trim();
        return s.length() - s.lastIndexOf(' ') - 1;
    }
}
