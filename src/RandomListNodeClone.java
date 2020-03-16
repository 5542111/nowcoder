
import java.util.HashMap;
import java.util.Map;

public class RandomListNodeClone {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead==null) {
            return null;
        }

        RandomListNode curNode=pHead;
         while (curNode!=null)
         {
             RandomListNode cloneNode=new RandomListNode(curNode.label);
             RandomListNode nextNode=curNode.next;
             curNode.next=cloneNode;
             cloneNode.next=nextNode;
             curNode=nextNode;
         }
         curNode= pHead;
         while (curNode!=null)
         {
             curNode.next.random=(curNode.random==null)?null:curNode.random.next;
             curNode=curNode.next.next;
         }
         curNode=pHead;
         RandomListNode pCloneHead=pHead.next;
         while (curNode!=null)
         {
             RandomListNode cloneNode=curNode.next;
             curNode.next=cloneNode.next;
             cloneNode.next=(cloneNode.next==null)?null:cloneNode.next.next;
             curNode=curNode.next;
         }
         return pCloneHead;
    }
    public RandomListNode Clone1(RandomListNode pHead){
        if (pHead==null) {
            return null;
        }

        Map<RandomListNode,RandomListNode> hs=new HashMap<>();
        RandomListNode temp=pHead;
        while(pHead!=null)
        {
            hs.put(pHead,new RandomListNode(pHead.label));
            pHead=pHead.next;
        }
        pHead=temp;
        while(pHead!=null)
        {
            hs.get(pHead).next=hs.get(pHead.next);
            hs.get(pHead).random=hs.get(pHead.random);
            pHead=pHead.next;
        }
        return hs.get(temp);

    }


}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}