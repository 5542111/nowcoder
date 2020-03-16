import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIn2DArray01 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list. add("王磊");
        list. add("的博客");
        String[] ch=list.toArray(new String[list.size()]);
        for (String str:ch)
        {
            System.out.println(str);
        }



        String[] array = new String[]{"王磊","的博客"};

        String s = "sadjjk sjakd jsak as dkl";

        System.out.println(s.replace(" ", "%20"));
    }

    public static boolean Find(int target, int[][] array) {
        //遍历多行  二分查询每一行  nlogn

        int rowsLen = array.length;  //列数
        int colsLen = array[0].length; //行数
        for (int i=rowsLen-1,j=0;j<colsLen&&i>=0;)
        {
            if (target==array[i][j])
            {
                return true;
            }
            else if (target<array[i][j])
            {
                i--;
            }
            else if (target>array[i][j])
            {
                j++;
            }

        }

        return false;
    }
}