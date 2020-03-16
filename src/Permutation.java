import java.util.*;

public class Permutation {
//    public ArrayList<String> Permutation1(String str) {
//
//    }
    public void PermutationHelper(char[] chars,int i,ArrayList<String> list){
        if (i==chars.length-1) {
            list.add(String.valueOf(chars));
        }
        else {
            Set<Character> charset=new HashSet<>();
            
        }

    }
    public void  swap(char[] temp,int i,int j)
    {
        char tmp=temp[i];
        temp[i]=temp[j];
        temp[j]=tmp;

    }
}
