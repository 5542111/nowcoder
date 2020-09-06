import java.util.ArrayList;
import java.util.List;

public class illegalIpCount {
    public static void main(String[] args) {
        dfs("19216801", 0, 0, new ArrayList<>());
    }

    public static void dfs(String str, int index, int level, List<String> list) {
        if (level == 4 || index == str.length()) {
            if (level == 4 && index == str.length()) {

                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < list.size(); i++) {
                    if (i != list.size() - 1) {
                        stringBuffer.append(list.get(i) + ".");
                    } else {
                        stringBuffer.append(list.get(i));
                    }
                }
                System.out.println(stringBuffer);
            }
            return;
        }
        //候选子串
        for (int i = 1; i < 4; i++) {
            int end = index + i > str.length() ? str.length() : index + i;
            String temp = str.substring(index, end);
            if (Integer.parseInt(temp) < 256 && (temp.equals("0") || !temp.startsWith("0"))) {
                //System.out.println(index+","+end+","+temp);
                list.add(temp);
                dfs(str, index + i, level + 1, list);
                list.remove(list.size() - 1);
            }

        }
    }

}
