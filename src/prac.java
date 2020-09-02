import java.util.ArrayList;
import java.util.List;

public class prac {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(200);
        System.out.println(list);
        for (int i = 0; i <201 ; i++) {
            list.add(i);
        }
        System.out.println(list);
        if (list.size()>200)
        {
            list.remove(0);
        }

        System.out.println(list.size());

    }
}
