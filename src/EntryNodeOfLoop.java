/**
 * Created by Eakon on 2017/6/10.
 *
 * 链表中环的入口节点
 *
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class EntryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead==null) return null;
        int step=numsOfNodeInLoop(pHead);
        if(step==0) return null;
        ListNode pre=pHead;
        ListNode head=pHead;
        while(step>0&&pre!=null){
            pre=pre.next;
            step--;
        }
        while(pre!=null&&head!=null){
            if(pre==head) return pre;
            pre=pre.next;
            head=head.next;
        }
        return null;
    }

    private int numsOfNodeInLoop(ListNode pHead){
        ListNode slow=pHead;
        ListNode fast=pHead.next;
        while(slow!=null&&fast!=null){
            if(slow==fast) break;
            slow=slow.next;
            fast=fast.next;
            if(fast!=null) fast=fast.next;
        }
        ListNode node=fast;
        int step=1;
        while(node!=null&&node.next!=fast){
            step++;
            node=node.next;
        }
        return node==null?0:step;
    }
}
