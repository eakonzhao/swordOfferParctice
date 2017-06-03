/**
 * Created by Eakon on 2017/6/1.
 */
public class FindKthToTail {

    public ListNode FindKthToTail(ListNode head, int k){
        if(head==null || k<=0){
            return null;
        }
        ListNode pre=head;
        ListNode result=head;
        for(int i=1; i<k; i++){
            if(pre.next!=null){
                pre=pre.next;
            }else{
                return null;
            }
        }
        while(pre.next!=null){
            pre=pre.next;
            result=result.next;
        }
        return result;
    }
}
