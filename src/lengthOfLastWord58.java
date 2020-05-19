

public class lengthOfLastWord58 {
    public static void main(String[] args) {
        lengthOfLastWord58 lengthOfLastWord = new lengthOfLastWord58();
        System.out.println(lengthOfLastWord.lengthOfLastWord2(" sdajdjsalk d sajd lkas "));
    }

    public int lengthOfLastWord(String s) {
        int num = 0;
        if (s != null) {
            String[] strings = s.split(" ");
            if (strings.length != 0) {
                num = strings[strings.length - 1].length();
            }

        }

        return num;
    }

    public int lengthOfLastWord2(String s) {

        s=s.trim();
        return s.length()-s.lastIndexOf(' ')-1;

    }
}
