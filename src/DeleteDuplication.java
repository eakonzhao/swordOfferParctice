/**
 * Created by Eakon on 2017/6/10.
 *
 * 删除链表中重复的节点
 *
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead){
        if(pHead==null) return null;
        ListNode pPreNode=null;
        ListNode pNode=pHead;
        while(pNode!=null){
            ListNode pNext=pNode.next;
            boolean needDelete=false;
            if(pNext!=null&&pNext.val==pNode.val){
                needDelete=true;
            }
            if(!needDelete){
                pPreNode=pNode;
                pNode=pNode.next;
            }else{
                int val=pNode.val;
                ListNode pToBeDel=pNode;
                while(pToBeDel!=null&&pToBeDel.val==val){
                    pNext=pToBeDel.next;
                    pToBeDel=pNext;
                }
                if(pPreNode==null){
                    pHead=pNext;
                }else{
                    pPreNode.next=pNext;
                }
                pNode=pNext;
            }
        }
        return pHead;
    }
}
