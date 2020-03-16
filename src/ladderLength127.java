import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

public class ladderLength127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.indexOf(endWord) == -1) {
            return 0;
        }

        wordList.add(beginWord);

        Queue<String> queue1=new LinkedList<>();
        Queue<String> queue2=new LinkedList<>();

        Set<String> hs1=new HashSet<>();
        Set<String> hs2=new HashSet<>();

        queue1.add(beginWord);
        queue2.add(endWord);

        hs1.add(beginWord);
        hs2.add(endWord);


        int count=0;
        Set<String> allWorldSet=new HashSet<>(wordList);

        while (!queue1.isEmpty()&&!queue2.isEmpty())
        {
            count++;
            if (queue1.size()>queue2.size()){
                Queue<String> tmp=queue1;
                queue1=queue2;
                queue2=tmp;

                Set<String> temp=hs1;
                hs1=hs2;
                hs2=temp;
            }
            int size1=queue1.size();
            while (size1-->0)
            {
                String s=queue1.poll();
                char[] chars=s.toCharArray();
                for (int i=0;i<s.length();i++)
                {
                    char c0=chars[i];
                    for (char c='a';c<'z';c++)
                    {
                        chars[i]=c;
                        String newString=new String(chars);
                        if (hs1.contains(newString))
                        {
                            continue;
                        }
                        if (hs2.contains(newString))
                        {
                            return count+1;
                        }
                        if (allWorldSet.contains(newString))
                        {
                            queue1.add(newString);
                            hs1.add(newString);
                        }
                    }
                    chars[i]=c0;
                }
            }
        }

        return 0;
    }
}
