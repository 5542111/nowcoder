public class ZipCharArr {
    public static void main(String[] args) {
        String str = "abbbccaaa";
        char[] chars = str.toCharArray();
        System.out.println(new ZipCharArr().zipLen(chars));
    }

    /**
     * 原数组压缩
     *
     * @param arr
     * @return
     */
    public int zipLen(char[] arr) {

        int n = arr.length;


        char ch = arr[0];
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        while (right < n) {
            sb.append(ch);
            while (right < n && arr[right] == ch) {
                right++;
            }
            if (right == left) {
                sb.append(1);
                right++;
                left = right;
                ch = arr[left];
            } else {
                sb.append(right - left);
                left = right;
                if (right>=n){

                }else{
                    ch = arr[left];
                }
            }

        }
        System.out.println(sb.toString());
        return sb.length();
    }
}
