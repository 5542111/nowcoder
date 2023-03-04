import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class a1487getFolderNames {


    public String[] getFolderNames(String[] names) {
        Map<String, Integer> index = new HashMap<String, Integer>();
        int n = names.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (!index.containsKey(name)) {
                res[i] = name;
                index.put(name, 1);
            } else {
                int k = index.get(name);
                while (index.containsKey( name +"("+k+")")) {
                    k++;
                }
                res[i] = name +"("+k+")";
                index.put(name, k + 1);
                index.put(name +"("+k+")", 1);
            }
        }
        return res;
    }


}
