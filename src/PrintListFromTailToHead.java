/**
 * Created by Eakon on 2017/5/29.
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 */

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 逆序数粗单链表
 */
public class PrintListFromTailToHead {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode!=null) {
            LinkedList<ListNode> stack = new LinkedList<>();
            stack.peek();
            while(listNode!=null){
                stack.push(listNode);
                listNode=listNode.next;
            }
            while(!stack.isEmpty()){
                ListNode listNode1 = stack.pop();
                list.add(listNode1.val);
            }
        }
        return list;
    }
}
