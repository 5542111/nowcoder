import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class restoreString1528 {
    public String restoreString(String s, int[] indices) {
        Map<Integer,Character> hs=new TreeMap<>();
        for (int i = 0; i < indices.length ; i++) {
            hs.put(indices[i],s.charAt(i));
        }
        StringBuffer stringBuffer=new StringBuffer();
        for (Map.Entry<Integer,Character> entry:hs.entrySet()){
            stringBuffer.append(entry.getValue());
        }
        return stringBuffer.toString();
    }
}
