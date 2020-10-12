public class strWithout3a3b984 {
    public static void main(String[] args) {
        System.out.println(new strWithout3a3b984().strWithout3a3b(6, 3));
    }
    public String strWithout3a3b(int A, int B) {
        StringBuilder ans = new StringBuilder();
        while(A > 0 && B > 0) {
            if(A - B > 0) {
                ans.append("aa");
                ans.append("b");
                A -= 2;
                B--;
            } else if(A == B) {
                ans.append("a");
                ans.append("b");
                A--;
                B--;
            } else {
                ans.append("bb");
                ans.append("a");
                A--;
                B -= 2;
            }
        }

        while(A-- > 0)
            ans.append("a");

        while(B-- > 0)
            ans.append("b");

        return ans.toString();
    }




}
