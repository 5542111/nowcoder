

public class lengthOfLastWord58 {
    public static void main(String[] args) {
        lengthOfLastWord58 lengthOfLastWord = new lengthOfLastWord58();
        System.out.println(lengthOfLastWord.lengthOfLastWord2(" sdajdjsalk d sajd lkas "));
    }
    public int lengthOfLastWord2(String s) {
        int num = 0;
        if (s != null) {
            String[] strings = s.split(" ");
            if (strings.length!=0)
            {
                num = strings[strings.length - 1].length();
            }

        }

        return num;
    }
    public int lengthOfLastWord3(String s) {

        s=s.trim();
        // return s.length()-s.lastIndexOf(' ')-1;
        if (s.length()<=1) return s.length();
        int LastIndex = s.length()-1;
        int i=0;
        int j=LastIndex;
        boolean flag=true;
        for (j=LastIndex;j>0;j--){
            if (s.charAt(j)!=' ')
            {
                flag=false;
                break;
            }

        }

        for (i=j;i>0;i--){

            if (flag==false&&s.charAt(i)==' '){
                break;
            }
        }
        if (i==0) return j-i+1;
        return j-i;

    }

    public int lengthOfLastWord(String s) {

        s=s.trim();
        return s.length()-s.lastIndexOf(' ')-1;


    }

}
