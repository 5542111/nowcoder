public class a1247minimumSwap {

    public int minimumSwap(String s1, String s2) {
        int xy = 0;
        int yx = 0;

        int len = s1.length();

        for (int i = 0; i < len; i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if (a == 'x' && b == 'y') {
                xy++;
            }
            if (a == 'y' && b == 'x') {
                yx++;
            }
        }
        if (((xy + yx) & 1) == 1) {
            return -1;
        }
        return xy / 2 + yx / 2 + xy % 2 + yx % 2;
    }
}
