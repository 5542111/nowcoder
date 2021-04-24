public class nextGreaterElement556 {
    public static void main(String[] args) {
        System.out.println(nextGreaterElement(1));
    }

    public static int nextGreaterElement(int n) {

        long max = (long) Integer.MAX_VALUE;
        long min = (long) Integer.MIN_VALUE;


        String str = String.valueOf(n);

        char[] chars = str.toCharArray();
        int index = chars.length - 1;
        char pre = chars[index];
        for (; index >= 0; index--) {
            if (chars[index] >= pre) {
                pre = chars[index];
            } else {
                break;
            }
        }
        if (index==-1){
            return -1;
        }

        for (int i = chars.length-1; i >index ; i--) {
            if (chars[i] > chars[index]){
                char temp = chars[index];
                chars[index] = chars[i];
                chars[i] = temp;
                break;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= index; i++) {
            sb.append(chars[i]);
        }
        for (int i = chars.length-1; i >index ; i--) {
            sb.append(chars[i]);
        }


        long x=Long.valueOf(sb.toString());
        if (x>max || x<min){
            return -1;
        }

        return (int)x;
    }
}
