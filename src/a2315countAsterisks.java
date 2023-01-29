public class a2315countAsterisks {
    public static void main(String[] args) {
        System.out.println(new a2315countAsterisks().countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
    }

    public int countAsterisks(String s) {
        int count = 0;
        boolean isCount = true;

        for (char c : s.toCharArray()) {
            if (isCount && c == '*') {
                count++;
            }
            if (c == '|') {
                isCount = !isCount;
            }
        }
        return count;
    }
}
