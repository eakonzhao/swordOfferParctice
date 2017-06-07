/**
 * Created by Eakon on 2017/6/7.
 *
 * 两个链表的第一个公共节点
 *
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null) return null;
        int length1 = 0;
        int length2 = 0;
        ListNode head1 = pHead1;
        ListNode head2 = pHead2;
        while(head1!=null){
            length1++;
            head1=head1.next;
        }
        while(head2!=null){
            length2++;
            head2=head2.next;
        }
        int distance;
        head1=pHead1;
        head2=pHead2;
        if(length1>length2){
            distance = length1-length2;
            for(int i=0; i<distance; i++){
                head1 = head1.next;
            }
        }else{
            distance = length2-length1;
            for(int i=0; i<distance; i++){
                head2 = head2.next;
            }
        }
        while(head1!=null&&head2!=null){
            if(head1==head2){
                return head1;
            }else{
                head1=head1.next;
                head2=head2.next;
            }
        }
        return null;
    }
}
